import java.util.*;
class SumaVarios{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa -1 para terminar");

        int suma = 0;
        
        System.out.println("Ingrese un numero positivo");
        int n = sc.nextInt();
        while(n != -1){
            suma += n;

            System.out.println("Ingrese un número positivo");
            n = sc.nextInt();
        }
        System.out.println("La suma total es: " + suma);
        
        sc.close();        

    }
}