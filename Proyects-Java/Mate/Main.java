import java.util.*;
class Main{
    public static void main(String[] args){
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        biblioteca.mostrarListaLibros();

        System.out.print("Ingrese el número de libro que desea buscar: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // BUG, java tenia que ser...//

        String[] libros = biblioteca.getLibros(); // Obtener el array de libros

        if(opcion >= 1 && opcion <= libros.length){
            String libroSeleccionado = libros[opcion - 1];
            biblioteca.buscarLibro(libroSeleccionado);
        }else{
            System.out.println("Opción inválida.");
        }
        scanner.close();
    }
}
