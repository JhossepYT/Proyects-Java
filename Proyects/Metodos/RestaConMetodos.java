import java.util.*;
class RestaConMetodos{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el primer valor: ");
        int a = sc.nextInt();
        System.out.println("Ingrese el segundo valor: ");
        int b = sc.nextInt();
        sc.close();
        int r = Resta.RestaD(a, b);
        System.out.println("La resta es: " + r);
    }
}