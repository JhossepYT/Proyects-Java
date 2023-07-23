import java.util.*;
public class Reconocedor_Mejorado{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int cantidadMayoresCero = 0;
        int cantidadMenoresCero = 0;
        int cantidadIgualesCero = 0;

        System.out.print("Ingrese los números separados por espacios: ");
        String numerosIngresados = scanner.nextLine();
        String[] numeros = numerosIngresados.split(" ");

        for (String numeroStr : numeros){
            int numero = Integer.parseInt(numeroStr);

            if(numero > 0){
                cantidadMayoresCero++;
            }else
                if(numero < 0){
                cantidadMenoresCero++;
                }else{
                cantidadIgualesCero++;
            }
        }

        System.out.println("Cantidad de números mayores que 0: " + cantidadMayoresCero);
        System.out.println("Cantidad de números menores que 0: " + cantidadMenoresCero);
        System.out.println("Cantidad de números iguales a 0: " + cantidadIgualesCero);
        scanner.close();
    }
}