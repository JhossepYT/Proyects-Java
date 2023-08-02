class TorresDeHanoi {
    public static void main(String[] args) {
        int discos = 3;
        hanoi(discos, 'A', 'B', 'C');
    }

    public static void hanoi(int n, char origen, char aux, char destino) {
        if (n == 1) {
            System.out.println("Mover disco 1 de " + origen + " a " + destino);
        } else {
            hanoi(n - 1, origen, destino, aux);
            System.out.println("Mover disco " + n + " de " + origen + " a " + destino);
            hanoi(n - 1, aux, origen, destino);
        }
    }
}