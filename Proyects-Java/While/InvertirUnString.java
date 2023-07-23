import java.util.*;
class InvertirUnString{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un texto: ");
        String texto = sc.nextLine();
        int longitud = texto.length();

        int i = longitud - 1;
        while(i >= 0){
            char caracter = texto.charAt(i);
            System.out.print(caracter);

            i--;
        }
        sc.close();
    }
}