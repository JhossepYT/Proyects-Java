import java.util.*;
class Problema01{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una frase: ");
        String frase = sc.nextLine().toLowerCase();
        int contadorCual = 0;
        int contadorComo = 0;

        int p_cual = frase.indexOf("cual");
        int p_como = frase.indexOf("como");
        while(p_cual != -1 || p_como != -1){
            if(p_cual != -1){
                p_cual = frase.indexOf("cual", p_cual + 1);
                contadorCual++;
            }
            if(p_como != -1){
                p_como = frase.indexOf("como", p_como + 1);
                contadorComo++;
            }
        }
        if(contadorCual == 0 && contadorComo == 0){
            System.out.println("No hay 'Cual' ni 'Como'");
        }else{
            if(contadorCual == contadorComo){
                System.out.println("Igual cantidad");
            }else{
                System.out.println("Distinta cantidad");
            }
        }
    }
}