import java.util.*;
class Nikole_3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese su primer apellido: ");
        String ap1 = sc.nextLine();
        System.out.print("Ingrese su segundo apellido: ");
        String ap2 = sc.nextLine();
        sc.close();

    /* Formar el monograma  */

        char inicialNombre = nombre.charAt(0);
        char inicialApellido1 = ap1.charAt(0);
        char inicialApellido2 = ap2.charAt(0);

    /* Dar el resultado */

        System.out.println("Su monograma es: " + inicialNombre + inicialApellido1 + inicialApellido2);
    }
}