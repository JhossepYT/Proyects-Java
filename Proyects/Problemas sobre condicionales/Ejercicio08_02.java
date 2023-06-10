//Velarde Saldaña Jhossep Fabritzio
import java.util.*;
class Ejercicio08_02{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el primer puntaje: ");
        int puntaje_1 = sc.nextInt();
        System.out.println("Ingrese el segundo puntaje: ");
        int puntaje_2 = sc.nextInt();
        sc.close();
        
        if(puntaje_1 >= 17 && puntaje_2 >= 17){
            System.out.println("Avanza a la siguiente etapa");
        }else{
            if(puntaje_1 <= 2 || puntaje_2 <= 2){
                System.out.println("NO avanzan y se despiden");
            }else{
                System.out.println("Se quedan en reserva");
            }          
        }    
    }
 }