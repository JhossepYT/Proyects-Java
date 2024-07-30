import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import javax.swing.*;
import model.User;
import dao.UserInfoDAO;

public class ArcadeVariantGame extends JFrame implements ActionListener {
  private JPanel gamePanel;
  private JLabel[][] cardMatrix;
  private int[][] gameBoard;
  private int[][] visibleCards;
  private Random random;
  private int flippedCards, firstCardValue, firstCardRow, firstCardCol, secondCardValue, secondCardRow, secondCardCol;
  private javax.swing.Timer flipTimer, gameTimer, initialFlipTimer;
  private int elapsedSeconds, minutes, timeLimit;
  private JLabel playerNameLabel, timerLabel, dateLabel, timeLabel, attemptsLabel;
  private User user;
  private JButton restartButton, backButton;
  private int imageFolderIndex;
  private JLabel[] trophyLabels;
  private int winCount;
  private int attempts; // Contador de intentos
  private int initialFlipTime; // Tiempo de revelación inicial de las cartas
  private int b = 5; // Número de carpetas de imágenes
  private List<Integer> usedFolders; // Lista de carpetas usadas

  // Constructor de la clase ArcadeVariantGame
  public ArcadeVariantGame(User user) {
    this.user = user;
    this.usedFolders = new ArrayList<>(); // Inicializa la lista de carpetas usadas
    this.imageFolderIndex = selectRandomFolder(true); // Permite repetidos al inicio
    this.winCount = 0;
    this.attempts = 0;
    initializeUI();
    initializeGame(user, 0);
  }

  // Método para seleccionar una carpeta aleatoria
  private int selectRandomFolder(boolean allowRepeat) {
    Random rand = new Random();
    List<Integer> availableFolders = new ArrayList<>();
    for (int i = 0; i < b; i++) {
      if (allowRepeat || !usedFolders.contains(i)) {
        availableFolders.add(i);
      }
    }
    int randomIndex = rand.nextInt(availableFolders.size());
    int selectedFolder = availableFolders.get(randomIndex);
    if (!allowRepeat) {
      usedFolders.add(selectedFolder); // Añadir la carpeta seleccionada a la lista de usadas
    }
    return selectedFolder;
  }

  // Método para inicializar la interfaz de usuario
  private void initializeUI() {
    setTitle("EL BOSQUE DE LOS GUARDIANES: La Batalla por la Armonia");
    setSize(1010, 720);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);

    gamePanel = new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon background = new ImageIcon("images/resources/backgroundGameplay.png");
        g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
      }
    };
    getContentPane().add(gamePanel);
    gamePanel.setLayout(null);

    addGameComponents();
  }

  // Método para inicializar el juego
  private void initializeGame(User user, int intentos) {
    int attempts = 0;
    if (intentos == 0) {
      attempts = 0;
    } else {
      attempts = intentos;
    }
    random = new Random();
    gameBoard = new int[4][5];
    visibleCards = new int[4][5];
    generateRandomCards();
    createCardMatrix();
    setupTimers(user, attempts);

    // Inicializar el tiempo de revelación de las cartas según el número de fases
    // ganadas
    switch (winCount) {
      case 0:
        initialFlipTime = 4000; // 4 segundos
        break;
      case 1:
        initialFlipTime = 3000; // 3 segundos
        break;
      case 2:
        initialFlipTime = 2000; // 2 segundos
        break;
      case 3:
        initialFlipTime = 1000; // 1 segundo
        break;
      default:
        initialFlipTime = 1000; // 1 segundo
        break;
    }

    revealAllCardsTemporarily();
  }

  // Método para añadir componentes del juego a la interfaz
  private void addGameComponents() {
    addLabel("Player: ", 40, 40, 150, 40, "Lucida Sans Unicode", 23);
    playerNameLabel = addLabel("", 125, 40, 150, 40, "Times New Roman", 28);

    addLabel("Time: ", 40, 80, 150, 40, "Lucida Sans Unicode", 23);
    timerLabel = addLabel("", 120, 80, 150, 40, "Times New Roman", 28);

    addLabel("Start Time: ", 40, 120, 150, 40, "Lucida Sans Unicode", 23);
    timeLabel = addLabel("", 170, 120, 150, 40, "Times New Roman", 28);

    addLabel("Date: ", 40, 160, 150, 40, "Lucida Sans Unicode", 23);
    dateLabel = addLabel("", 115, 160, 150, 40, "Times New Roman", 28);

    addLabel("Attempts: ", 40, 200, 150, 40, "Lucida Sans Unicode", 23);
    attemptsLabel = addLabel("", 160, 200, 150, 40, "Times New Roman", 28);

    backButton = createImageButton("images/resources/NormalMenu.png", "images/resources/HoverMenu.png");
    backButton.setBounds(115, 590, 150, 48);
    backButton.addActionListener(e -> backToMenu());
    gamePanel.add(backButton);

    restartButton = createImageButton("images/resources/NormalRestart.png", "images/resources/HoverRestart.png");
    restartButton.setBounds(115, 540, 150, 48); // Mover un poco más arriba
    restartButton.addActionListener(this);
    gamePanel.add(restartButton);

    trophyLabels = new JLabel[5];

    // Primera fila de dos trofeos
    trophyLabels[0] = new JLabel(new ImageIcon("images/trophys/1.png"));
    trophyLabels[0].setBounds(48, 250, 80, 80);
    gamePanel.add(trophyLabels[0]);

    trophyLabels[1] = new JLabel(new ImageIcon("images/trophys/3.png"));
    trophyLabels[1].setBounds(128, 250, 80, 80);
    gamePanel.add(trophyLabels[1]);

    // Segunda fila de dos trofeos
    trophyLabels[2] = new JLabel(new ImageIcon("images/trophys/5.png"));
    trophyLabels[2].setBounds(48, 340, 80, 80);
    gamePanel.add(trophyLabels[2]);

    trophyLabels[3] = new JLabel(new ImageIcon("images/trophys/7.png"));
    trophyLabels[3].setBounds(128, 340, 80, 80);
    gamePanel.add(trophyLabels[3]);

    // Tercer fila con un trofeo centrado
    trophyLabels[4] = new JLabel(new ImageIcon("images/trophys/9.png"));
    trophyLabels[4].setBounds(89, 420, 80, 80);
    gamePanel.add(trophyLabels[4]);

    updateDateTime();
  }

  // Método para crear un botón con imagen
  private JButton createImageButton(String normalImage, String hoverImage) {
    JButton button = new JButton(new ImageIcon(normalImage));
    button.setRolloverIcon(new ImageIcon(hoverImage));
    button.setBorderPainted(false);
    button.setContentAreaFilled(false);
    button.setFocusPainted(false);
    button.setOpaque(false);
    return button;
  }

  // Método para reiniciar el juego
  private void resetGameOld() {
    flippedCards = 0;
    elapsedSeconds = 0;
    minutes = 0;
    attemptsLabel.setText("0");
    attempts = 0;
    imageFolderIndex = selectRandomFolder(true); // Permite repetir la carpeta al reiniciar
    generateRandomCards();

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 5; j++) {
        visibleCards[i][j] = 0;
        cardMatrix[i][j].setIcon(new ImageIcon("images/" + imageFolderIndex + "/0.png"));
      }
    }

    timerLabel.setText("0:00");
    updateDateTime();

    gameTimer.restart();
    revealAllCardsTemporarily();
  }

  // Método para manejar eventos de acción
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == restartButton) {
      int choice = JOptionPane.showConfirmDialog(this,
          "¿Está seguro de que desea reiniciar el juego?\nSe perderá su progreso.",
          "Reiniciar Juego", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
      if (choice == JOptionPane.YES_OPTION) {
        resetGameOld();
      }
    }
  }

  // Método para volver al menú principal
  private void backToMenu() {
    this.dispose();
    StartMenu startMenu = new StartMenu(user);
    startMenu.setVisible(true);
  }

  // Método para añadir una etiqueta a la interfaz
  private JLabel addLabel(String text, int x, int y, int width, int height, String fontName, int fontSize) {
    JLabel label = new JLabel(text);
    label.setBounds(x, y, width, height);
    label.setFont(new Font(fontName, Font.PLAIN, fontSize));
    gamePanel.add(label);
    return label;
  }

  // Método para actualizar la fecha y hora
  private void updateDateTime() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    dateLabel.setText(dateFormat.format(new Date()));

    Calendar calendar = new GregorianCalendar();
    timeLabel.setText(String.format("%02d:%02d:%02d",
        calendar.get(Calendar.HOUR_OF_DAY),
        calendar.get(Calendar.MINUTE),
        calendar.get(Calendar.SECOND)));
  }

  // Método para generar cartas aleatorias
  private void generateRandomCards() {
    ArrayList<Integer> cardValues = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
      cardValues.add(i);
      cardValues.add(i);
    }
    Collections.shuffle(cardValues);

    int index = 0;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 5; j++) {
        gameBoard[i][j] = cardValues.get(index++);
        visibleCards[i][j] = 0;
      }
    }
  }

  // Método para crear la matriz de cartas
  private void createCardMatrix() {
    cardMatrix = new JLabel[4][5];
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 5; j++) {
        cardMatrix[i][j] = new JLabel();
        cardMatrix[i][j].setBounds(350 + (j * 125), 30 + (i * 156), 125, 156);
        cardMatrix[i][j].setIcon(new ImageIcon("images/" + imageFolderIndex + "/0.png"));
        cardMatrix[i][j].setVisible(true);
        gamePanel.add(cardMatrix[i][j], 0);
        addCardListener(cardMatrix[i][j], i, j);
      }
    }
  }

  // Método para añadir un listener a una carta
  private void addCardListener(JLabel card, int row, int col) {
    card.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        if (visibleCards[row][col] == 0 && flippedCards != 2) {
          flipCard(row, col);
        }
      }
    });
  }

  // Método para voltear una carta
  private void flipCard(int row, int col) {
    visibleCards[row][col] = gameBoard[row][col];
    cardMatrix[row][col]
        .setIcon(new ImageIcon("images/" + imageFolderIndex + "/" + visibleCards[row][col] + ".png"));
    flippedCards++;

    if (flippedCards == 1) {
      firstCardValue = gameBoard[row][col];
      firstCardRow = row;
      firstCardCol = col;
    } else if (flippedCards == 2) {
      secondCardValue = gameBoard[row][col];
      secondCardRow = row;
      secondCardCol = col;
      attempts++; // Incrementar el contador de intentos
      attemptsLabel.setText(String.valueOf(attempts));
      flipTimer.restart();
    }
  }

  // Método para configurar los temporizadores
  private void setupTimers(User user, int attempts) {
    flipTimer = new javax.swing.Timer(500, e -> checkCards(user, attempts));
    flipTimer.setRepeats(false);

    switch (winCount) {
      case 0:
        timeLimit = 4 * 60;
        break;
      case 1:
        timeLimit = 3 * 60;
        break;
      case 2:
        timeLimit = 2 * 60;
        break;
      case 3:
        timeLimit = 1 * 60;
        break;
      default:
        timeLimit = 1 * 60;
        break;
    }

    gameTimer = new javax.swing.Timer(1000, e -> updateGameTimer());
    gameTimer.start();
  }

  // Método para revelar todas las cartas temporalmente
  private void revealAllCardsTemporarily() {
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 5; j++) {
        cardMatrix[i][j].setIcon(new ImageIcon("images/" + imageFolderIndex + "/" + gameBoard[i][j] + ".png"));
      }
    }

    initialFlipTimer = new javax.swing.Timer(initialFlipTime, e -> hideAllCards());
    initialFlipTimer.setRepeats(false);
    initialFlipTimer.start();
  }

  // Método para ocultar todas las cartas
  private void hideAllCards() {
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 5; j++) {
        if (visibleCards[i][j] != -1) {
          cardMatrix[i][j].setIcon(new ImageIcon("images/" + imageFolderIndex + "/0.png"));
          visibleCards[i][j] = 0;
        }
      }
    }
    flippedCards = 0;
  }

  // Método para verificar las cartas volteadas
  private void checkCards(User user, int attempts) {
    if (firstCardValue == secondCardValue) {
      visibleCards[firstCardRow][firstCardCol] = -1;
      visibleCards[secondCardRow][secondCardCol] = -1;
      if (checkWinCondition()) {
        gameWon(user, attempts);
      }
    } else {
      visibleCards[firstCardRow][firstCardCol] = 0;
      visibleCards[secondCardRow][secondCardCol] = 0;
      cardMatrix[firstCardRow][firstCardCol].setIcon(new ImageIcon("images/" + imageFolderIndex + "/0.png"));
      cardMatrix[secondCardRow][secondCardCol].setIcon(new ImageIcon("images/" + imageFolderIndex + "/0.png"));
    }
    flippedCards = 0;
  }

  // Método para verificar la condición de victoria
  private boolean checkWinCondition() {
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 5; j++) {
        if (visibleCards[i][j] != -1) {
          return false;
        }
      }
    }
    return true;
  }

  // Método para manejar la victoria del juego
  private void gameWon(User user, int attempts) {
    if (gameTimer.isRunning()) {
      gameTimer.stop();
      winCount++;
      if (winCount < 5) {
        trophyLabels[winCount - 1].setIcon(new ImageIcon("images/trophys/" + (winCount * 2) + ".png"));
        JOptionPane.showMessageDialog(this, "You won this round! Starting next round.");
        resetGame();
        imageFolderIndex = selectRandomFolder(false); // No permite repetir la carpeta al ganar una etapa
        initializeGame(user, attempts);
      } else {
        trophyLabels[winCount - 1].setIcon(new ImageIcon("images/trophys/" + (winCount * 2) + ".png"));
        JOptionPane.showMessageDialog(this, "Congratulations! You have won 5 rounds! You Won the Game");
        saveRecordAndExitW(user);
      }
    }
  }

  // Método que se llama cuando el juego termina debido a que el tiempo se ha
  // agotado.
  private void gameOver() {
    if (gameTimer.isRunning()) {
      gameTimer.stop();
      JOptionPane.showMessageDialog(this, "Time's up! You lost.");
      saveRecordAndExit(user); // Guardar el número de intentos aunque pierda
    }
  }

  // Método para reiniciar el juego, restableciendo el temporizador y las cartas
  // visibles.
  private void resetGame() {
    elapsedSeconds = 0;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 5; j++) {
        cardMatrix[i][j].setIcon(new ImageIcon("images/" + imageFolderIndex + "/0.png"));
        visibleCards[i][j] = 0;
      }
    }
    flippedCards = 0;
  }

  // Método para guardar el registro del usuario y salir del juego.
  private void saveRecordAndExit(User user) {
    UserInfoDAO userInfoDAO = new UserInfoDAO();
    userInfoDAO.reconnect();
    userInfoDAO.saveAttempts(user, attempts); // Guardar el número de intentos
    userInfoDAO.reconnect();
    User updatedUser = userInfoDAO.getUserInfoByName(user.getUsername());
    userInfoDAO.reconnect();
    gameTimer.stop();
    StartMenu startMenu = new StartMenu(updatedUser);
    startMenu.setVisible(true);
    this.dispose();
  }

  // Método para guardar el registro del usuario, incrementar el contador de
  // victorias y salir del juego.
  private void saveRecordAndExitW(User user) {
    UserInfoDAO userInfoDAO = new UserInfoDAO();
    userInfoDAO.reconnect();
    userInfoDAO.addPlusOneWin(user);
    userInfoDAO.reconnect();
    userInfoDAO.saveAttempts(user, attempts); // Guardar el número de intentos
    userInfoDAO.reconnect();
    User updatedUser = userInfoDAO.getUserInfoByName(user.getUsername());
    userInfoDAO.reconnect();
    gameTimer.stop();
    StartMenu startMenu = new StartMenu(updatedUser);
    startMenu.setVisible(true);
    this.dispose();
  }

  // Método para actualizar el temporizador del juego y verificar si el tiempo se
  // ha agotado.
  private void updateGameTimer() {
    elapsedSeconds++;
    int remainingTime = timeLimit - elapsedSeconds;
    if (remainingTime <= 0) {
      gameOver();
    }
    timerLabel.setText(String.format("%02d:%02d", remainingTime / 60, remainingTime % 60));
  }

  // Método para establecer el nombre del jugador en la interfaz.
  public void setPlayerName(String name) {
    playerNameLabel.setText(name);
  }

  public static void main(String[] args) {
    User user = new User("test", "test");
    HistoryVariantGame game = new HistoryVariantGame(user);
    game.setPlayerName(user.getUsername());
    game.setVisible(true);
  }
}