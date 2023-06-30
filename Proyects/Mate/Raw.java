import java.util.*;
class Raw{
    private String[] libros;
    private boolean[] disponibilidad;

    public Raw(){
        libros = new String[]{"Libro 1", "Libro 2", "Libro 3", "Libro 4", "Libro 5"};
        disponibilidad = new boolean[]{true, true, false, true, false};
    }

    public void buscarLibro(String libro){
        boolean encontrado = false;
        for (int i = 0; i < libros.length; i++){
            if (libros[i].equalsIgnoreCase(libro)) {
                encontrado = true;
                if (disponibilidad[i]) {
                    System.out.println("El libro \"" + libro + "\" está disponible en la biblioteca.");
                } else {
                    System.out.println("El libro \"" + libro + "\" no está disponible en la biblioteca.");
                }
                break;
            }
        }
        if(!encontrado){
            System.out.println("El libro \"" + libro + "\" no se encuentra en la biblioteca.");
        }
    }

    public void mostrarListaLibros() {
        System.out.println("Lista de libros disponibles:");
        for (int i = 0; i < libros.length; i++) {
            System.out.println((i + 1) + ". " + libros[i]);
        }
    }

    public static void main(String[] args) {
        Raw biblioteca = new Raw();
        Scanner scanner = new Scanner(System.in);

        biblioteca.mostrarListaLibros();

        System.out.print("Ingrese el número de libro que desea buscar: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        if (opcion >= 1 && opcion <= biblioteca.libros.length) {
            String libroSeleccionado = biblioteca.libros[opcion - 1];
            biblioteca.buscarLibro(libroSeleccionado);
        } else {
            System.out.println("Opción inválida.");
        }
        scanner.close();
    }
}
