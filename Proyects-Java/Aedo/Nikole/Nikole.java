import java.util.*;
class Nikole{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = sc.next();
        nombre = nombre.toUpperCase();
        char primeraLetra = nombre.charAt(0);
        int posicionPrimeraA = nombre.indexOf("A");
        char ultimaLetra = Character.toLowerCase(nombre.charAt(nombre.length() - 1));
        System.out.println("Tu monograma es: " + primeraLetra + ultimaLetra + posicionPrimeraA);
        sc.close();
    }
}