class SumaDigitosUno{
    public static int sumaDigitos(int n){
        int suma = 0;
        while(n > 0){
            int d = n % 10;
            suma += d;
            n /= 10;
        }
        return suma;
    }
}