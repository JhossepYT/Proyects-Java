import java.util.*;
class SumaConMetodos{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.close();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int d = Suma.sumaD(a, b);
        System.out.println(d);
    }
}