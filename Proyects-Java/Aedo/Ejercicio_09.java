import java.util.*;
class Ejercicio_09{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Año? ");
        int año = sc.nextInt();
        sc.close();
        
        if ((año % 4 == 0 && año % 100 != 0) || año % 400 == 0){
            System.out.println(año + " es un año bisiesto.");
        }else{
            System.out.println(año + " no es un año bisiesto.");
        }
    }
}