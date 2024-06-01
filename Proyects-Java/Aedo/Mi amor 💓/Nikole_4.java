import javax.swing.*;
class Nikole_4{
    public static void main(String[] args){
        
         /* Ventana */

         JFrame miVentana = new JFrame();
         miVentana.setSize(300, 300);
         miVentana.setTitle("Monogramainador");
 
         /* Si sale bien, dentro de la ventana iría esto */
 
         JTextField cuadroNombre = new JTextField();
         cuadroNombre.setBounds(45, 40, 200, 30);
         JTextField cuadroApellido1 = new JTextField();
         cuadroApellido1.setBounds(45, 90, 200, 30);
         JTextField cuadroApellido2 = new JTextField();
         cuadroApellido2.setBounds(45, 140, 200, 30);
         JButton btnMonograma = new JButton("Generar Monograma");
         btnMonograma.setBounds(64, 187, 160, 30);
         JLabel etiqueta = new JLabel();
         etiqueta.setBounds(77, 225, 200, 30);
 
         miVentana.setLayout(null);
         miVentana.add(cuadroNombre);
         miVentana.add(cuadroApellido1);
         miVentana.add(cuadroApellido2);
         miVentana.add(btnMonograma);
 
         /* Parte código en sí */
 
         btnMonograma.addActionListener(e -> {
             String nombre = cuadroNombre.getText();
             String ap1 = cuadroApellido1.getText();
             String ap2 = cuadroApellido2.getText();
 
             // Obtener el monograma
             char inicialNombre = nombre.charAt(0);
             char inicialApellido1 = ap1.charAt(0);
             char inicialApellido2 = ap2.charAt(0);
 
             // Construir el monograma
             String monograma = "" + inicialNombre + inicialApellido1 + inicialApellido2;
             etiqueta.setText("Su monograma es: " + monograma);
         });
 
         /* Agrego la etiqueta con la respuesta a la ventana */
 
         miVentana.add(etiqueta);
         miVentana.setVisible(true);
         miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}