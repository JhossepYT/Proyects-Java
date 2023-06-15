import java.util.*;
class Metodos_Prueba{    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero entero positivo: ");
        int num = sc.nextInt();
        int suma = SumaDigitosUno.sumaDigitos(num);
        while(suma > 10){
            num = suma;
            suma = SumaDigitosUno.sumaDigitos(num);
        }
        System.out.println(suma);
    }
}