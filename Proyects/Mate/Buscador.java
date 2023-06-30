class Buscador{
    public void buscarLibro(String[] libros, boolean[] disponibilidad, String libro){
        boolean encontrado = false;
        for(int i = 0; i < libros.length; i++){
            if(libros[i].equalsIgnoreCase(libro)){
                encontrado = true;
                if(disponibilidad[i]) {
                    System.out.println("El libro \"" + libro + "\" está disponible en la biblioteca.");
                }else{
                    System.out.println("El libro \"" + libro + "\" no está disponible en la biblioteca.");
                }
                break;
            }
        }
        if(!encontrado){
            System.out.println("El libro \"" + libro + "\" no se encuentra en la biblioteca.");
        }
    }
}
