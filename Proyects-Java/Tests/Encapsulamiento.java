class Encapsulamiento{
    public static void main(String[] args) {
        Metodo1 test = new Metodo1();
        test.setEdad(15);
        System.out.println("La edad es: " + test.getEdad());
        test.setNombre("Juan");
        System.out.println("Su nombre es: " + test.getNombre());
    }
}
