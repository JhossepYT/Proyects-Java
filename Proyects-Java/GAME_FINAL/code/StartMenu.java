import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import dao.UserInfoDAO;
import model.User;

public class StartMenu extends JFrame implements ActionListener {
    @SuppressWarnings("unused")
    private JLabel welcomeLabel;
    @SuppressWarnings("unused")
    private JLabel winsLabel;
    private JButton historyModeButton, arcadeModeButton, creditsButton, exitButton, logoutButton;
    private User user;
    private Image backgroundImage;

    // Constructor del menú de inicio
    public StartMenu(User user) {
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        userInfoDAO.reconnect();
        String username = user.getUsername();
        userInfoDAO.reconnect();
        this.user = userInfoDAO.getUserInfoByName(username);
        backgroundImage = new ImageIcon("images/resources/background.png").getImage();
        initializeUI();
    }

    // Método para inicializar la interfaz de usuario
    private void initializeUI() {
        setTitle("EL BOSQUE DE LOS GUARDIANES: La Batalla por la Armonia");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        BackgroundPanel panel = new BackgroundPanel();
        panel.setLayout(null);
        getContentPane().add(panel);

        addUIComponents(panel);
    }

    // Método para añadir los componentes de la interfaz de usuario al panel
    private void addUIComponents(JPanel panel) {
        welcomeLabel = addStyledLabel(panel, user.getUsername().toUpperCase(), 645, 500, 240, 30, 12);
        winsLabel = addStyledLabel(panel, "Wins: " + user.getWins(), 645, 520, 240, 30, 12);

        historyModeButton = addImageButton(panel, "images/resources/NormalHistoryMode.png",
                "images/resources/HoverHistoryMode.png", 510, 145, 200, 50);
        arcadeModeButton = addImageButton(panel, "images/resources/NormalArcade.png",
                "images/resources/HoverArcade.png", 510, 205, 200, 50);
        creditsButton = addImageButton(panel, "images/resources/NormalCredits.png", "images/resources/HoverCredits.png",
                510,
                265, 200, 50);
        exitButton = addImageButton(panel, "images/resources/NormalExit.png", "images/resources/HoverExit.png", 510,
                325, 200,
                50);
        logoutButton = addImageButton(panel, "images/resources/NormalLogout.png", "images/resources/HoverLogout.png",
                510, 390,
                200, 50);
    }

    // Método para añadir un JLabel estilizado al panel
    private JLabel addStyledLabel(JPanel panel, String text, int x, int y, int width, int height, int fontSize) {
        JLabel label = new JLabel(
                "<html><div style='text-align: right; color: white; font-family: BahnschriftBold; font-size: "
                        + fontSize + "px;'>" + text + "</div></html>");
        label.setBounds(x, y, width, height);
        panel.add(label);
        return label;
    }

    // Método para añadir un JButton con imágenes al panel
    private JButton addImageButton(JPanel panel, String imagePath, String hoverImagePath, int x, int y, int width,
            int height) {
        ImageIcon defaultIcon = new ImageIcon(imagePath);
        ImageIcon hoverIcon = new ImageIcon(hoverImagePath);
        JButton button = new JButton(defaultIcon);
        button.setBounds(x, y, width, height);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        button.addActionListener(this);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setIcon(hoverIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setIcon(defaultIcon);
            }
        });
        panel.add(button);
        return button;
    }

    // Método que maneja los eventos de acción de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == arcadeModeButton) {
            startGame();
        } else if (e.getSource() == historyModeButton) {
            historyModeGame();
        } else if (e.getSource() == creditsButton) {
            showCredits();
        } else if (e.getSource() == exitButton) {
            exitGame();
        } else if (e.getSource() == logoutButton) {
            logout();
        }
    }

    // Método para iniciar el modo de juego arcade
    private void startGame() {
        ArcadeVariantGame game = new ArcadeVariantGame(user);
        game.setPlayerName(user.getUsername());
        game.setVisible(true);
        this.dispose();
    }

    // Método para iniciar el modo de juego historia
    public void historyModeGame() {
        this.dispose();
        HistoryMode historyMode = new HistoryMode(user);
        this.dispose();
    }

    // Método para mostrar los créditos del juego
    private void showCredits() {
        String credits = "EL BOSQUE DE LOS GUARDIANES: La Batalla por la Armonia\n\n" +
                "Created by: Jhossep Fabritzio Velarde Saldaña\n" +
                "Version: 1.0\n" +
                "Date: 27/07/24\n\n" +
                "This game was created as an educational project\n" +
                "to demonstrate basic programming concepts in Java\n" +
                "and GUI development using Swing.";

        JOptionPane.showMessageDialog(this, credits, "Credits", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para salir del juego
    private void exitGame() {
        int choice = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to exit the game?",
                "Exit Game", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    // Método para cerrar sesión y volver a la ventana de inicio de sesión/registro
    private void logout() {
        LoginRegisterWindow loginWindow = new LoginRegisterWindow();
        loginWindow.setVisible(true);
        this.dispose();
    }

    // Clase interna para el panel de fondo con una imagen
    class BackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}