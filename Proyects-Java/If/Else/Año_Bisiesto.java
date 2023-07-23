import java.util.*;
class Año_Bisiesto{
    public static void main(String[] args){
        Scanner  sc = new Scanner(System.in);
        System.out.println("Ingrese un año: ");
        int year  = sc.nextInt();
        boolean cuatrocientos = year % 400 == 0;
        boolean cien = year % 100 ==0;
        boolean cuatro = year % 4 ==0;
        sc.close(); 

        if(cuatrocientos){
            System.out.println("Es un año bisiesto");
        }else{
            if(cien){
                System.out.println("NO es un año bisiesto");
            }else{
                if(cuatro){
                System.out.println("Es un año bisiesto");
                }else{
                    System.out.println("NO es un año bisiesto");
                }
            }
        }
    }
}