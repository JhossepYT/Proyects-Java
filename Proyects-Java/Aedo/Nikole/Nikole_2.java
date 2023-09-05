import javax.swing.*;
class Nikole_2 {
    public static void main(String[] args) {

        /* Ventana */

        JFrame miVentana = new JFrame();
        miVentana.setSize(300, 300);
        miVentana.setTitle("Monogramainador");

        /* Si sale bien, dentro de la ventana iria esto */

        JTextField cuadroNombre = new JTextField();
        cuadroNombre.setBounds(45, 70, 200, 30);
        JButton btnMonograma = new JButton("Mostrar Monograma");
        btnMonograma.setBounds(70, 130, 150, 30);
        JLabel etiqueta = new JLabel();
        etiqueta.setBounds(80, 194, 200, 30);

        miVentana.setLayout(null);
        miVentana.add(cuadroNombre);
        miVentana.add(btnMonograma);

        /* Parte código en sí */

        btnMonograma.addActionListener(e -> {
            String nombre = cuadroNombre.getText();
            nombre = nombre.toUpperCase();
            char primeraLetra = nombre.charAt(0);
            int posicionPrimeraA = nombre.indexOf("A");
            char ultimaLetra = Character.toLowerCase(nombre.charAt(nombre.length() - 1));
            String monograma = primeraLetra + "" + ultimaLetra + posicionPrimeraA;
            etiqueta.setText("Tu monograma es: " + monograma);
        });

        /* Agrego la etiqueda con la respuesta a la ventana y con fe aparece */

        miVentana.add(etiqueta);
        miVentana.setVisible(true);
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}