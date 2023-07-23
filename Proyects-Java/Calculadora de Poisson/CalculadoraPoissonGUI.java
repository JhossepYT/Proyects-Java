import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class CalculadoraPoissonGUI extends JFrame implements ActionListener {
    private JTextField variableATextField;
    private JTextField xTextField;
    private JLabel resultadoLabel;

    /* Parte visual */

    public CalculadoraPoissonGUI() {
        setTitle("Calculadora de Poisson");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel variableALabel = new JLabel("Valor para la variable a:");
        variableALabel.setBounds(10, 10, 150, 20);
        add(variableALabel);

        variableATextField = new JTextField();
        variableATextField.setBounds(160, 10, 120, 20);
        add(variableATextField);

        JLabel xLabel = new JLabel("Valor para x:");
        xLabel.setBounds(10, 40, 150, 20);
        add(xLabel);

        xTextField = new JTextField();
        xTextField.setBounds(160, 40, 120, 20);
        add(xTextField);

        JButton calcularButton = new JButton("Calcular");
        calcularButton.setBounds(100, 70, 100, 30);
        calcularButton.addActionListener(this);
        add(calcularButton);

        resultadoLabel = new JLabel();
        resultadoLabel.setBounds(10, 110, 280, 20);
        add(resultadoLabel);
    }

    /* Codigo en si */

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Calcular")) {
            try {
                String aStr = variableATextField.getText();
                String xStr = xTextField.getText();

                double a = Double.parseDouble(aStr);
                double x = Double.parseDouble(xStr);

                double f = calculateFactorial(x);

                double numerador = (Math.pow(a, x)) * Math.exp(-a);
                double denominador = f;
                double respuesta = numerador / denominador;

                double respuestaPorcentaje = respuesta * 100;

                DecimalFormat df = new DecimalFormat("#.##"); // Formato con dos decimales
                String respuestaFormateada = df.format(respuestaPorcentaje);

                resultadoLabel.setText("El resultado de la fórmula de Poisson es: " + respuestaFormateada + "%");
            } catch (NumberFormatException ex) {
                resultadoLabel.setText("Error: Ingresa valores numéricos válidos.");
            } catch (IllegalArgumentException ex) {
                resultadoLabel.setText("Error: " + ex.getMessage());
            }
        }
    }

    /* Factorial */

    public static double calculateFactorial(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo.");
        }

        double result = 1;
        for (int i = 1; i <= (int) x; i++) {
            result *= i;
        }
        return result;
    }

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CalculadoraPoissonGUI calculator = new CalculadoraPoissonGUI();
                calculator.setVisible(true);
            }
        });
    }
}