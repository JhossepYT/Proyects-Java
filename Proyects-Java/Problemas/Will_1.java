import javax.swing.*;
import java.awt.event.*;

public class Will_1 extends JFrame {
    private JLabel lblDificultad;
    private JTextField txtDificultad;
    private JButton btnIniciar;
    private JTextArea txtResultado;

    private int totalJuegos;
    private int juegosPC;
    private int juegosUsuario;

    public Will_1() {
        super("Adivina el número");

        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(null);

        // Crear los componentes
        lblDificultad = new JLabel("Ingrese la dificultad: ");
        lblDificultad.setBounds(10, 10, 150, 30);

        txtDificultad = new JTextField();
        txtDificultad.setBounds(160, 10, 120, 30);

        btnIniciar = new JButton("Iniciar");
        btnIniciar.setBounds(100, 50, 100, 30);

        txtResultado = new JTextArea();
        txtResultado.setBounds(10, 90, 270, 160);
        txtResultado.setEditable(false);

        // Agregar los componentes a la ventana
        add(lblDificultad);
        add(txtDificultad);
        add(btnIniciar);
        add(txtResultado);

        // Agregar el evento click al botón Iniciar
        btnIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int dificultad = Integer.parseInt(txtDificultad.getText());

                double r = Math.random();
                int random = (int)(r * dificultad) + 1;

                txtResultado.setText("");
                txtResultado.append("Trata de adivinar qué número tengo guardado:\n");

                int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un número:"));

                txtResultado.append("Nivel de dificultad: " + dificultad + "\n");
                txtResultado.append("Número generado: " + random + "\n");
                txtResultado.append("Número ingresado: " + numero + "\n");

                int conta_user = 0;
                int conta_pc = 0;

                if (random == numero) {
                    conta_user++;
                    txtResultado.append("Ganaste\n");
                } else {
                    conta_pc++;
                    txtResultado.append("Gana la PC\n");
                }

                juegosPC += conta_pc;
                juegosUsuario += conta_user;
                totalJuegos++;
            }
        });

        // Agregar evento al cerrar la ventana
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                int empates = totalJuegos - juegosPC - juegosUsuario;
                String resumen = "Resumen:\n";
                resumen += "Total de juegos: " + totalJuegos + "\n";
                resumen += "Juegos ganados por la PC: " + juegosPC + "\n";
                resumen += "Juegos ganados por el usuario: " + juegosUsuario + "\n";
                resumen += "Empates: " + empates + "\n";

                if (juegosPC == juegosUsuario) {
                    resumen += "Empate global\n";
                } else if (juegosPC > juegosUsuario) {
                    resumen += "Ganador global: PC\n";
                } else {
                    resumen += "Ganador global: Usuario\n";
                }

                JOptionPane.showMessageDialog(null, resumen);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Will_1 will_1 = new Will_1();
                will_1.setVisible(true);
            }
        });
    }
}
