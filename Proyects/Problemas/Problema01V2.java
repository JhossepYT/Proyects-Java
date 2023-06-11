import java.util.*;
public class Problema01V2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine().toLowerCase();
        sc.close();
        int numCual = 0;
        int numComo = 0;

        int i = 0;
        while(i < cadena.length() - 3){
            if( "como".equals(cadena.substring(i, i + 4)) ){
                numComo++;
            }
            if( "cual".equals(cadena.substring(i, i + 4)) ){
                numCual++;
            }
            i++;
        }

        if(numCual == numComo){
            System.out.println("Igual cantidad");
        }else{
            System.out.println("Distinta cantidad");
        }
    }
}