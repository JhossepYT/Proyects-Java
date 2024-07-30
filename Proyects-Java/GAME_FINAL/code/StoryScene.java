import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.sound.sampled.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class StoryScene extends JFrame {
  private JLabel imageLabel;
  private JLabel subtitleLabel;
  private Timer imageTimer;
  private List<String> subtitles;
  private List<String> imagePaths;
  private String audioPathF;
  private int currentImageIndex = 0;
  private Clip audioClip;
  private User user;

  private static final int IMAGE_INTERVAL = 4250;

  // Constructor para la escena de la historia
  public StoryScene(String imageFolderPath, String audioPath, String subtitlesPath, User user) {
    this.subtitles = loadSubtitles(subtitlesPath);
    this.imagePaths = loadImagePaths(imageFolderPath);

    if (this.imagePaths.isEmpty()) {
      JOptionPane.showMessageDialog(this,
          "No se encontraron imágenes. Por favor, verifica las rutas.", "Error",
          JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }

    setTitle("EL BOSQUE DE LOS GUARDIANES: La Batalla por la Armonia");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    setSize(1010, 720);
    setLocationRelativeTo(null); // Centrar la ventana

    imageLabel = new JLabel();
    add(imageLabel, BorderLayout.CENTER);

    subtitleLabel = new JLabel("", SwingConstants.CENTER);
    subtitleLabel.setFont(new Font("Serif", Font.BOLD, 28));
    subtitleLabel.setForeground(Color.WHITE);
    subtitleLabel.setOpaque(true);
    subtitleLabel.setBackground(new Color(0, 0, 0, 150));
    subtitleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JPanel transparentPanel = new JPanel(new GridBagLayout());
    transparentPanel.setOpaque(false);
    transparentPanel.add(subtitleLabel);

    add(transparentPanel, BorderLayout.SOUTH);

    getContentPane().setBackground(Color.BLACK); // Establecer fondo negro para eliminar cualquier zona blanca

    addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        updateImage();
      }
    });

    SwingUtilities.invokeLater(() -> {
      initializeContent(user);
      playAudio(audioPath);
    });

    setVisible(true);
  }

  // Constructor nuevo para cinemática y redirección al menú principal
  public StoryScene(String imageFolderPath, String audioPath, String subtitlesPath, String imageFolderPath2,
      String audioPath2, String subtitlesPath2, User user, boolean isCinematic, int subtitleFontSize) {
    this.user = user;
    if (isCinematic) {
      this.subtitles = loadSubtitles(subtitlesPath);
      this.imagePaths = loadImagePaths(imageFolderPath);
      this.audioPathF = audioPath;
    } else {
      this.subtitles = loadSubtitles(subtitlesPath2);
      this.imagePaths = loadImagePaths(imageFolderPath2);
      this.audioPathF = audioPath2;
    }

    if (this.imagePaths.isEmpty()) {
      JOptionPane.showMessageDialog(this,
          "No se encontraron imágenes. Por favor, verifica las rutas.", "Error",
          JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }

    setTitle("EL BOSQUE DE LOS GUARDIANES: La Batalla por la Armonia");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    setSize(1010, 720);
    setLocationRelativeTo(null); // Centrar la ventana

    imageLabel = new JLabel();
    add(imageLabel, BorderLayout.CENTER);

    subtitleLabel = new JLabel("", SwingConstants.CENTER);
    subtitleLabel.setFont(new Font("Comic Sans", Font.BOLD, subtitleFontSize));
    subtitleLabel.setForeground(Color.WHITE);
    subtitleLabel.setOpaque(true);
    subtitleLabel.setBackground(new Color(0, 0, 0, 150));
    subtitleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JPanel transparentPanel = new JPanel(new GridBagLayout());
    transparentPanel.setOpaque(false);
    transparentPanel.add(subtitleLabel);

    add(transparentPanel, BorderLayout.SOUTH);

    getContentPane().setBackground(Color.BLACK); // Establecer fondo negro para eliminar cualquier zona blanca

    addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        updateImage();
      }
    });

    SwingUtilities.invokeLater(() -> {
      initializeContentForCinematic();
      playAudio(audioPathF);
    });

    setVisible(true);
  }

  // Método para inicializar el contenido de la historia
  private void initializeContent(User user) {
    updateImage();
    startStorySequence(user);
  }

  // Método para inicializar el contenido de la cinemática
  private void initializeContentForCinematic() {
    updateImage();
    startCinematicSequence();
  }

  // Método para cargar los subtítulos desde un archivo
  private List<String> loadSubtitles(String subtitlesPath) {
    List<String> loadedSubtitles = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(subtitlesPath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        loadedSubtitles.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(this, "Error loading subtitles: " + e.getMessage(), "Error",
          JOptionPane.ERROR_MESSAGE);
    }
    return loadedSubtitles;
  }

  // Método para cargar las rutas de las imágenes desde una carpeta
  private List<String> loadImagePaths(String imageFolderPath) {
    List<String> paths = new ArrayList<>();
    File folder = new File(imageFolderPath);

    if (!folder.exists() || !folder.isDirectory()) {
      JOptionPane.showMessageDialog(this, "La carpeta " + imageFolderPath + " no existe o no es un directorio.",
          "Error",
          JOptionPane.ERROR_MESSAGE);
      return paths;
    }

    for (int i = 1;; i++) {
      File file = new File(folder, i + ".png");
      if (file.exists()) {
        paths.add(file.getAbsolutePath());
      } else {
        break;
      }
    }

    return paths;
  }

  // Método para actualizar la imagen mostrada
  private void updateImage() {
    if (currentImageIndex < imagePaths.size()) {
      ImageIcon icon = new ImageIcon(imagePaths.get(currentImageIndex));
      Image img = icon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
      imageLabel.setIcon(new ImageIcon(img));
    }
  }

  // Método para iniciar la secuencia de la historia
  private void startStorySequence(User user) {
    imageTimer = new Timer(IMAGE_INTERVAL, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (currentImageIndex < imagePaths.size()) {
          updateImage();
          updateSubtitle(subtitles.get(currentImageIndex));
          currentImageIndex++;
        } else {
          imageTimer.stop();
          if (audioClip != null) {
            audioClip.stop();
            audioClip.close();
          }
          dispose();
          HistoryVariantGame game = new HistoryVariantGame(user);
          game.setPlayerName(user.getUsername());
          game.setVisible(true);
        }
      }
    });
    imageTimer.start();
  }

  // Método para iniciar la secuencia de la cinemática
  private void startCinematicSequence() {
    imageTimer = new Timer(IMAGE_INTERVAL, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (currentImageIndex < imagePaths.size()) {
          updateImage();
          updateSubtitle(subtitles.get(currentImageIndex));
          currentImageIndex++;
        } else {
          imageTimer.stop();
          if (audioClip != null) {
            audioClip.stop();
            audioClip.close();
          }
          returnToMainMenu();
        }
      }
    });
    imageTimer.start();
  }

  // Método para actualizar el subtítulo mostrado
  private void updateSubtitle(String text) {
    subtitleLabel.setText(text);
  }

  // Método para reproducir el audio
  private void playAudio(String audioPath) {
    try {
      File audioFile = new File(audioPath);
      AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
      audioClip = AudioSystem.getClip();
      audioClip.open(audioStream);
      audioClip.start();
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(this, "Error playing audio: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  // Método para volver al menú principal
  private void returnToMainMenu() {
    SwingUtilities.invokeLater(() -> {
      StartMenu startMenu = new StartMenu(user);
      startMenu.setVisible(true);
      dispose(); // Cierra la ventana de la cinemática
    });
  }

  // Método principal para iniciar la aplicación
  public static void main(String[] args) {
    String imageFolderPath = "images\\scenes\\GoodEnding";
    String audioPath = "sound\\GoodEnding\\sound.wav";
    String subtitlesPath = "code\\subtitles\\GoodEnding.txt";
    User user = new User("test", "test");

    SwingUtilities.invokeLater(() -> {
      try {
        new StoryScene(imageFolderPath, audioPath, subtitlesPath, imageFolderPath, audioPath, subtitlesPath, user,
            true, 24);
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al iniciar la aplicación: " + e.getMessage(), "Error",
            JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
      }
    });
  }
}