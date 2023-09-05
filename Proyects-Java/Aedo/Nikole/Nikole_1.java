import javax.swing.*;
class Nikole_1 {
    public static void main(String[] args) {

        /* Con fe funciona la parte visual del codigo */

        JFrame miVentana;
        miVentana = new JFrame();
        miVentana.setSize(300, 400);
        miVentana.setTitle("Monogramador");
        miVentana.setVisible(false);

        /* Contenido de la ventana */

        String name = JOptionPane.showInputDialog(null, "¿Cual es tu nombre?");

        /* Parte codigo en si */

        String nombre = name;
        nombre = nombre.toUpperCase();
        char primeraLetra = nombre.charAt(0);
        char ultimaLetra = Character.toLowerCase(nombre.charAt(nombre.length() - 1));
        int posicionPrimeraA = nombre.indexOf("A");
        String monograma = primeraLetra + "" + ultimaLetra + posicionPrimeraA;
        JLabel etiqueta = new JLabel("Tu monograma es: " + monograma);
        JOptionPane.showMessageDialog(null, etiqueta);
    }
}