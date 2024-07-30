import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import dao.UserInfoDAO;
import model.User;

public class LoginRegisterWindow extends JFrame implements ActionListener {
  private JTextField usernameField;
  private JPasswordField passwordField;
  private JButton loginButton, registerButton;
  private UserInfoDAO userInfoDAO;
  private Image backgroundImage;

  // Constructor de la ventana de inicio de sesión/registro
  public LoginRegisterWindow() {
    userInfoDAO = new UserInfoDAO();
    backgroundImage = new ImageIcon("images/resources/loginBackground.png").getImage();
    initializeUI();
  }

  // Método para inicializar la interfaz de usuario
  private void initializeUI() {
    setTitle("Inicio de Sesión / Registro");
    setSize(450, 300);
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
    addStyledLabel(panel, "Usuario:", 78, 55, 100, 30, 15);
    usernameField = new JTextField();
    usernameField.setBounds(180, 55, 170, 30);
    panel.add(usernameField);

    addStyledLabel(panel, "Contraseña:", 63, 105, 130, 30, 15);
    passwordField = new JPasswordField();
    passwordField.setBounds(180, 105, 170, 30);
    panel.add(passwordField);

    loginButton = addImageButton(panel, "images/resources/NormalLogin.png",
        "images/resources/HoverLogin.png", 60, 160, 150, 48);
    registerButton = addImageButton(panel, "images/resources/NormalRegister.png",
        "images/resources/HoverRegister.png", 220, 160, 150, 48);
  }

  // Método para añadir un JLabel estilizado al panel
  private JLabel addStyledLabel(JPanel panel, String text, int x, int y, int width, int height, int fontSize) {
    JLabel label = new JLabel("<html><div style='color: blacks; font-family: Bahnschrift; font-size: " + fontSize
        + "px;'>" + text + "</div></html>");
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
    String username = usernameField.getText();
    String password = new String(passwordField.getPassword());

    if (username.isEmpty() || password.isEmpty()) {
      JOptionPane.showMessageDialog(this, "Por favor ingresar un Usuario y Contraseña", "Error",
          JOptionPane.ERROR_MESSAGE);
      return;
    }

    if (e.getSource() == loginButton) {
      userInfoDAO.reconnect();
      login(username, password);
    } else if (e.getSource() == registerButton) {
      userInfoDAO.reconnect();
      register(username, password);
    }
  }

  // Método para manejar el inicio de sesión
  private void login(String username, String password) {
    User user = userInfoDAO.verifyAndGetUser(username, password);
    if (user == null) {
      userInfoDAO.reconnect();
      JOptionPane.showMessageDialog(this, "Credenciales Inválidas", "Error", JOptionPane.ERROR_MESSAGE);
      dispose();
      new LoginRegisterWindow().setVisible(true);
    } else {
      JOptionPane.showMessageDialog(this, "Bienvenido " + user.getUsername(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
      openStartMenu(user);
    }
  }

  // Método para manejar el registro de un nuevo usuario
  private void register(String username, String password) {
    boolean success = userInfoDAO.addUser(username, password);
    userInfoDAO.reconnect();
    if (success) {
      userInfoDAO.reconnect();
      User user = new User(username, password);
      openStartMenu(user);
    } else {
      JOptionPane.showMessageDialog(this, "Registro Fallido", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  // Método para abrir el menú de inicio después de iniciar sesión o registrarse
  private void openStartMenu(User user) {
    StartMenu startMenu = new StartMenu(user);
    startMenu.setVisible(true);
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

  // Método principal para iniciar la aplicación
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      LoginRegisterWindow loginRegisterWindow = new LoginRegisterWindow();
      loginRegisterWindow.setVisible(true);
    });
  }
}