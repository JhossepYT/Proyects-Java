class Biblioteca{
    private String[] libros;
    private boolean[] disponibilidad;

    public Biblioteca(){
        libros = new String[]{"Libro 1", "Libro 2", "Libro 3", "Libro 4", "Libro 5"};
        disponibilidad = new boolean[]{true, true, false, true, false};
    }

    public String[] getLibros(){
        return libros;
    }

    public void buscarLibro(String libro){
        Buscador buscador = new Buscador();
        buscador.buscarLibro(libros, disponibilidad, libro);
    }

    public void mostrarListaLibros(){
        Mostrador mostrador = new Mostrador();
        mostrador.mostrarListaLibros(libros);
    }
}
