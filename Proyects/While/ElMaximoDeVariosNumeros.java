import java.util.*;
class ElmaximoDeVariosNumeros{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Diga cuantos numeros se ingresaran: ");
        int n = sc.nextInt();
        System.out.println("Ingrese los valores: ");
        int mayor = Integer.MIN_VALUE;

        int i = 0;
        while(i < n){
            int v = sc.nextInt();
            if(v > mayor){
                mayor = v;
            }

            i++;
        }
        System.out.println("El número mayor es: " + mayor);
        sc.close();
    }
}