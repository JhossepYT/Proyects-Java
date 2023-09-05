import java.util.*;
class Nikole_5{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese su nombre completo (Nombre Apellido1 Apellido2): ");
        String nombreCompleto = sc.nextLine();
        sc.close();

        /* Dividir el nombre completo en partes */

        String[] partes = nombreCompleto.split(" ");
        String nombre = partes[0];
        String ap1 = partes[1];
        String ap2 = partes[2];

        /* Obtener el monograma */

        char inicialNombre = nombre.charAt(0);
        char inicialApellido1 = ap1.charAt(0);
        char inicialApellido2 = ap2.charAt(0);
        String monograma = "" + inicialNombre + inicialApellido1 + inicialApellido2;
               
        /* Imprimir el monograma */

        System.out.println("Su monograma es: " + monograma);
    }
}