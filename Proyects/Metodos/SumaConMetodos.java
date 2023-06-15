import java.util.*;
class SumaConMetodos{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese primer sumando: ");
        int a = sc.nextInt();
        System.out.println("Ingrese segundo sumando: ");
        int b = sc.nextInt();
        int d = Suma.sumaD(a, b);
        System.out.println("La suma es: " + d);
        sc.close();
    }
}