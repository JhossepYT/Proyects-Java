import java.util.*;
class Problema02{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la longitud de la cadena: ");
        int longitud = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese la secuencia de nucleotidos: ");
        String nucleotidos = sc.nextLine().toUpperCase();
        boolean valida = true;
        sc.close();

        int i = 0;
        while(i < nucleotidos.length()){
            char restriccion  = nucleotidos.charAt(i);
            if(restriccion != 'A' && restriccion != 'T' && restriccion != 'G' && restriccion != 'C'){
                System.out.println("Ingrese una cadena valida: "); 
                valida = false;
                break;
            }
            i++;
        }
        if(valida){
            if(longitud < nucleotidos.length()){
                String cadena = nucleotidos.substring(0, longitud);
                nucleotidos = nucleotidos.substring(longitud + 1);
                int posicion = nucleotidos.indexOf(cadena);

                int contador = 0;
                while(posicion != - 1){
                    posicion = nucleotidos.indexOf(cadena, posicion + 1);
                    contador++; 
                }
                if(contador == 0){
                    System.out.println("La secuencia de " + longitud + " caracteres: " + cadena + " No se vuelve a repetir.");
                    }
                else{
                    System.out.println("La secuencia de " + longitud + " caracteres: " + cadena + " Se repite " + contador + " veces.");
                }
            }            
        }
    }
}