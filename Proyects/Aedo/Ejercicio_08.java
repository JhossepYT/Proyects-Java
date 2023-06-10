import java.util.*;
class Ejercicio_08{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double discriminante = b * b - 4*a*c;
        double solucion1, solucion2;
        sc.close();

            if(discriminante < 0 ){
                System.out.println("Una de las solciones no pertenece a los reales");
            } else if( a != 0) {
                solucion1 = (-b + Math.sqrt(discriminante)) / 2 * a;
                solucion2 = (-b - Math.sqrt(discriminante)) / 2 * a;
                System.out.println("Soluciones: " + solucion1 + " ; " + solucion2);
            } else {
                solucion1 = -c/b;
                System.out.println("Solucion: " + solucion1);
        }
    }
}