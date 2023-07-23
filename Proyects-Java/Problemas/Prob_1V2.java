import java.util.*;
class Prob_1V2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una frase: ");
        String frase = sc.nextLine().toLowerCase();
        int contadorCual = 0;
        int contadorComo = 0;
        sc.close();

        int i = 0;
        while(i < frase.length() - 3){
            if(frase.substring(i, i + 4).equals("cual")){
                contadorCual++;
                i += 4;
            }else{
                if(frase.substring(i, i + 4).equals("como")){
                    contadorComo++;
                    i += 4;
                }else{
                    i++;
                }
            } 
        }
        
        if(contadorCual == 0 && contadorComo == 0){
            System.out.println("No aparecen 'cual' ni 'como'");
        }else{
            if(contadorCual == contadorComo){
                System.out.println("Igual cantidad");
            }else{
                System.out.println("Distinta cantidad");
            }
        } 
    }
}