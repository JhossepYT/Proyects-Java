import java.util.*;
public class Maximo_NumeroV2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese los números separados por espacios: ");
        String numeros = sc.nextLine();
        String[] numerosArray = numeros.split(" ");
        int maximo = Integer.MIN_VALUE;

        for(String numeroStr : numerosArray){
            int numero = Integer.parseInt(numeroStr);
            if(numero > maximo){
                maximo = numero;
            }
        }
        System.out.println("El número máximo es: " + maximo);
        sc.close();
    }
}