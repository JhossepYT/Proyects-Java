
import java.util.*;
public class Prob3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantas canciones: ");
        int cantidadCanciones = sc.nextInt();
        int total = 0;
        System.out.println("Cual es la duracion de las canciones: ");

        for(int i = 0; i < cantidadCanciones; i++){
            int duracionCancion = sc.nextInt();
            total += duracionCancion;
        }
        System.out.println("El tiempo total es: " + total);
    }
}