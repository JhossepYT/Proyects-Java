import javax.swing.*;
class Nikole_6{
    public static void main(String[] args){

        /* Ventana */

        JFrame miVentana = new JFrame();
        miVentana.setSize(300, 300);
        miVentana.setTitle("Monogramainador");

        /* Si sale bien, dentro de la ventana iría esto */

        JTextField cuadroNombreCompleto = new JTextField();
        cuadroNombreCompleto.setBounds(45, 70, 200, 30);
        JButton btnMonograma = new JButton("Mostrar Monograma");
        btnMonograma.setBounds(70, 130, 150, 30);
        JLabel etiqueta = new JLabel();
        etiqueta.setBounds(80, 194, 200, 30);

        miVentana.setLayout(null);
        miVentana.add(cuadroNombreCompleto);
        miVentana.add(btnMonograma);

        /* Parte código en sí */

        btnMonograma.addActionListener(e -> {
            String nombreCompleto = cuadroNombreCompleto.getText();

            /*Dividir el nombre completo en partes usando matriz de string */

            String[] partes = nombreCompleto.split(" ");
            String nombre = partes[0];
            String ap1 = partes[1];
            String ap2 = partes[2];

            /* Obtener el monograma */
            
            char inicialNombre = nombre.charAt(0);
            char inicialApellido1 = ap1.charAt(0);
            char inicialApellido2 = ap2.charAt(0);

            /* Construir el monograma */

            String monograma = "" + inicialNombre + inicialApellido1 + inicialApellido2;
            etiqueta.setText("Su monograma es: " + monograma);
        });

        /* Agrego la etiqueda con la respuesta a la ventana y con fe aparece */

        miVentana.add(etiqueta);
        miVentana.setVisible(true);
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}