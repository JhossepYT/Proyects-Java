import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import javax.swing.*;
import model.User;
import dao.UserInfoDAO;

// Clase principal del juego HistoryVariantGame que extiende JFrame.
public class HistoryVariantGame extends JFrame {
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
    private int imageFolderIndex;
    private JLabel[] trophyLabels;
    private int winCount;
    private int attempts; // Contador de intentos
    private int initialFlipTime; // Tiempo de revelación inicial de las cartas
    private int b = 5;
    private String imageFolderPath = "images\\scenes\\GoodEnding";
    private String audioPath = "sound\\GoodEnding\\sound.wav";
    private String subtitlesPath = "code\\subtitles\\GoodEnding.txt";
    private String imageFolderPath2 = "images\\scenes\\BadEnding";
    private String audioPath2 = "sound\\BadEnding\\sound.wav";
    private String subtitlesPath2 = "code\\subtitles\\BadEnding.txt";
    private List<Integer> usedFolders; // Lista de carpetas usadas

    // Constructor que inicializa el juego con el usuario proporcionado.
    public HistoryVariantGame(User user) {
        this.user = user;
        this.usedFolders = new ArrayList<>(); // Inicializa la lista de carpetas usadas
        this.imageFolderIndex = selectRandomFolder();
        this.winCount = 0;
        this.attempts = 0;
        initializeUI();
        initializeGame(user, 0);
    }

    // Método para seleccionar una carpeta aleatoria de imágenes.
    private int selectRandomFolder() {
        Random rand = new Random();
        List<Integer> availableFolders = new ArrayList<>();
        for (int i = 0; i < b; i++) {
            if (!usedFolders.contains(i)) {
                availableFolders.add(i);
            }
        }
        int randomIndex = rand.nextInt(availableFolders.size());
        int selectedFolder = availableFolders.get(randomIndex);
        usedFolders.add(selectedFolder); // Añadir la carpeta seleccionada a la lista de usadas
        return selectedFolder;
    }

    // Método para inicializar la interfaz de usuario.
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
                ImageIcon icon = new ImageIcon("images\\resources\\backgroundGameplay.png"); // Ruta de la imagen de fondo
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        getContentPane().add(gamePanel);
        gamePanel.setLayout(null);

        addGameComponents();
    }

    // Método para inicializar el juego con el usuario y los intentos
    // proporcionados.
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

    // Método para añadir componentes del juego a la interfaz.
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
        attemptsLabel = addLabel("", 155, 200, 150, 40, "Times New Roman", 28);

        // Botón de regreso al menú con imagen y hover
        JButton backButton = new JButton(new ImageIcon("images\\resources\\NormalMenu.png")); // Imagen normal del botón
        backButton.setRolloverIcon(new ImageIcon("images\\resources\\HoverMenu.png")); // Imagen de hover del botón
        backButton.setBounds(115, 590, 150, 48);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false); // Opcional: Para quitar el borde de enfoque cuando el botón es seleccionado
        backButton.addActionListener(e -> backToMenu());
        gamePanel.add(backButton);

        trophyLabels = new JLabel[5];

        // Primera fila de dos trofeos
        trophyLabels[0] = new JLabel(new ImageIcon("images\\trophys\\1.png"));
        trophyLabels[0].setBounds(48, 250, 80, 80);
        gamePanel.add(trophyLabels[0]);

        trophyLabels[1] = new JLabel(new ImageIcon("images\\trophys\\3.png"));
        trophyLabels[1].setBounds(128, 250, 80, 80);
        gamePanel.add(trophyLabels[1]);

        // Segunda fila de dos trofeos
        trophyLabels[2] = new JLabel(new ImageIcon("images\\trophys\\5.png"));
        trophyLabels[2].setBounds(48, 340, 80, 80);
        gamePanel.add(trophyLabels[2]);

        trophyLabels[3] = new JLabel(new ImageIcon("images\\trophys\\7.png"));
        trophyLabels[3].setBounds(128, 340, 80, 80);
        gamePanel.add(trophyLabels[3]);

        // Tercer fila con un trofeo centrado
        trophyLabels[4] = new JLabel(new ImageIcon("images\\trophys\\9.png"));
        trophyLabels[4].setBounds(89, 420, 80, 80);
        gamePanel.add(trophyLabels[4]);

        updateDateTime();
    }

    // Método para regresar al menú principal.
    private void backToMenu() {
        this.dispose();
        StartMenu startMenu = new StartMenu(user);
        startMenu.setVisible(true);
    }

    // Método para añadir una etiqueta (JLabel) a la interfaz.
    private JLabel addLabel(String text, int x, int y, int width, int height, String fontName, int fontSize) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setFont(new Font(fontName, Font.PLAIN, fontSize));
        gamePanel.add(label);
        return label;
    }

    // Método para actualizar la fecha y hora en la interfaz.
    private void updateDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateLabel.setText(dateFormat.format(new Date()));

        Calendar calendar = new GregorianCalendar();
        timeLabel.setText(String.format("%02d:%02d:%02d",
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND)));
    }

    // Método para generar cartas aleatorias en el tablero.
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

    // Método para crear la matriz de cartas y añadirlas al panel del juego.
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

    // Método para añadir un listener a cada carta para manejar el evento de clic.
    private void addCardListener(JLabel card, int row, int col) {
        card.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (visibleCards[row][col] == 0 && flippedCards != 2) {
                    flipCard(row, col);
                }
            }
        });
    }

    // Método para voltear una carta y actualizar el estado del juego.
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

    // Método para configurar los temporizadores del juego.
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

    // Método para revelar temporalmente todas las cartas al inicio del juego.
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

    // Método para ocultar todas las cartas después de haberlas revelado
    // temporalmente.
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

    // Método para verificar si las dos cartas volteadas son iguales.
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

    // Método para verificar si el jugador ha ganado el juego.
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

    // Método que se llama cuando el jugador gana el juego.
    private void gameWon(User user, int attempts) {
        if (gameTimer.isRunning()) {
            gameTimer.stop();
            winCount++;
            if (winCount < 5) {
                trophyLabels[winCount - 1].setIcon(new ImageIcon("images/trophys/" + (winCount * 2) + ".png"));
                JOptionPane.showMessageDialog(this, "You won this round! Starting next round.");
                resetGame();
                imageFolderIndex = selectRandomFolder(); // No permite repetir la carpeta al ganar una etapa
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
        gameTimer.stop();
        this.dispose();
        SwingUtilities.invokeLater(() -> {
            try {
                new StoryScene(imageFolderPath2, audioPath2, subtitlesPath2, imageFolderPath, audioPath, subtitlesPath,
                        user, true, 24);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al iniciar la aplicación Good Ending: " + e.getMessage(),
                        "Error Good Ending",
                        JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        });
    }

    // Método para guardar el registro del usuario, incrementar el contador de
    // victorias y salir del juego.
    private void saveRecordAndExitW(User user) {
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        userInfoDAO.reconnect();
        userInfoDAO.addPlusOneWin(user);
        userInfoDAO.reconnect();
        User updatedUser = userInfoDAO.getUserInfoByName(user.getUsername());
        userInfoDAO.reconnect();
        gameTimer.stop();
        this.dispose();
        SwingUtilities.invokeLater(() -> {
            try {
                new StoryScene(imageFolderPath, audioPath, subtitlesPath, imageFolderPath2, audioPath2, subtitlesPath2,
                        user, true, 24);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al iniciar la aplicación Good Ending: " + e.getMessage(),
                        "Error Good Ending",
                        JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        });
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

    // Método principal para iniciar el juego.
    public static void main(String[] args) {
        User user = new User("test", "test");
        HistoryVariantGame game = new HistoryVariantGame(user);
        game.setPlayerName(user.getUsername());
        game.setVisible(true);
    }
}