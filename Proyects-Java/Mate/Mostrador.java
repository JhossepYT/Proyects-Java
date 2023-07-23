class Mostrador{
    public void mostrarListaLibros(String[] libros){
        System.out.println("Lista de libros disponibles:");
        for(int i = 0; i < libros.length; i++){
            System.out.println((i + 1) + ". " + libros[i]);
        }
    }
}
