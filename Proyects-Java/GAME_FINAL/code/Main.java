/**
 * Clase principal para iniciar la aplicación del juego de memoria.
 */
public class Main {
    /**
     * Punto de entrada de la aplicación.
     * Crea y muestra el menú de inicio.
     *
     * @param args Argumentos de la línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        LoginRegisterWindow loginWindow = new LoginRegisterWindow();
        loginWindow.setVisible(true);
    }
}