import java.util.*;
public class Problema02V2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        //linea agregada para evitar error con la captura por teclado del ENTER
        sc.nextLine();
        String adn = sc.nextLine();
        String cadena = adn.substring(0, num);
        sc.close();

        int repet = -1;
        int i = 0;
        while(i < adn.length() - num + 1 ){
            if(cadena.equals(adn.substring(i, i + num))){
                repet++;
            }

            i++;

        }
        System.out.println(repet);
    }
}