import java.util.*;
public class CalculosMentales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        double x2 = x + 5;
        double x3 = x2 * x2;
        double x4 = x3 / (x / 3);
        double x5 = x4 * x4 * x4;
        String sixdecimales = String.format("%.6f %.6f %.6f %.6f %.6f", x, x2, x3, x4, x5);
        sc.close();
        System.out.println(sixdecimales);
    }
}
