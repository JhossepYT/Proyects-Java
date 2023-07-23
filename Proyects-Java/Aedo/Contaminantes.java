import java.util.*;
public class Contaminantes{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el número de automóviles a verificar: ");
        int n = sc.nextInt();

        int sumaPuntosContaminantes = 0;
        int menorContaminacion = 100;
        int mayorContaminacion = 0;

        for(int i = 1; i <= n; i++){
            System.out.print("Ingrese los puntos contaminantes del automóvil " + i + ": ");
            int puntosContaminantes = sc.nextInt();

            sumaPuntosContaminantes += puntosContaminantes;

            if(puntosContaminantes < menorContaminacion){
                menorContaminacion = puntosContaminantes;
            }

            if(puntosContaminantes > mayorContaminacion){
                mayorContaminacion = puntosContaminantes;
            }
        }
        double promedioContaminacion = (double) sumaPuntosContaminantes / n;
        
        System.out.println("El promedio de puntos contaminantes es: " + promedioContaminacion);
        System.out.println("El automóvil que menos contaminó tiene: " + menorContaminacion + " puntos");
        System.out.println("El automóvil que más contaminó tiene: " + mayorContaminacion + " puntos");
        sc.close();
    }
}
