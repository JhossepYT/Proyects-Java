import java.util.*;
public class Maximo_Numero{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de números: ");
        int n = sc.nextInt();
        int maximo = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            System.out.print("Ingrese el número: " + (i + 1) + ": ");
            int numero = sc.nextInt();
            if(numero > maximo){
                maximo = numero;
            }
        }
        System.out.println("El número máximo es: " + maximo);
        sc.close();
    }
}
