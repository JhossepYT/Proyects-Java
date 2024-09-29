// Importación de las bibliotecas necesarias para la interfaz gráfica y el modelo de usuario.
import javax.swing.*;
import model.User;

// Clase HistoryMode que maneja el modo historia del juego.
public class HistoryMode {
    // Rutas de los recursos necesarios para la escena de la historia.
    String imageFolderPath = "images\\scenes\\Introduction";
    String audioPath = "sound\\IntroductionAudio.wav";
    String subtitlesPath = "code\\subtitles\\subtitles.txt";

    // Constructor que inicializa el modo historia con el usuario proporcionado.
    public HistoryMode(User user) {
        // Ejecuta la inicialización de la escena de la historia en el hilo de despacho de eventos de Swing.
        SwingUtilities.invokeLater(() -> {
            try {
                new StoryScene(imageFolderPath, audioPath, subtitlesPath, user);
            } catch (Exception e) {
                // Muestra un mensaje de error si ocurre una excepción durante la inicialización.
                JOptionPane.showMessageDialog(null, "Error al iniciar la aplicación: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        });
    }
}