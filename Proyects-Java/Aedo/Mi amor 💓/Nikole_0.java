import java.util.*;
class Nikole_0{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa tu nombre: ");
        String nombre = sc.next().toUpperCase();
        char primeraLetra = nombre.charAt(0);
        char ultimaLetra = nombre.charAt(nombre.length() - 1);
        int posicionPrimeraA = nombre.indexOf("A");
        System.out.println("Tu monograma es: " + primeraLetra + ultimaLetra + posicionPrimeraA);
        sc.close();
    }
}