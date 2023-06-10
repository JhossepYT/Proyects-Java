import galapagos.*;
import java.util.*;
class Poligono_N_Lados{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de lados:");
        int n = sc.nextInt();
        int angulo = (180 - 180 * (n - 2) / n);
        sc.close();
        Turtle t = new Turtle();
        t.speed(500);
        
        int i = 0;
        while(i < n){
            t.move(50);
            t.turn(angulo);
            i++;
        }
    }
}