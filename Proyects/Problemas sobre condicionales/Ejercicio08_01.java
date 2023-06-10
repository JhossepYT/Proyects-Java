//Velarde Saldaña Jhossep Fabritzio
import java.util.*;
class Ejercicio08_01{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su puntaje de hoy: ");
        int puntos = sc.nextInt();
        System.out.println("Ingrese si hoy es fin de semana (True or False): ");
        boolean finDeSemana = sc.nextBoolean();
        sc.close();

        if(finDeSemana){
            if(puntos >= 50){
                System.out.println("Fue un buen dia de estudio");
            }else{
                System.out.println("Fue un mal dia de estudio");
            }
        }else{
            if(puntos >= 50 && puntos <= 70){
                System.out.println("Fue un buen dia de estudio");
            }else{
                System.out.println("Fue un mal dia de estudio");
            }
        }
    }
}        