import java.util.*;
class Factorial_Sin_Metodos{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el primer número: ");
        int num1 = sc.nextInt();
        System.out.print("Ingrese el segundo número: ");
        int num2 = sc.nextInt();
        sc.close();

        if(num1 >= 0 && num2 >= 0){
            long factorial1 = 1;
            long factorial2 = 1;

            for(int i = 1; i <= num1; i++){
                factorial1 *= i;
            }

            for(int i = 1; i <= num2; i++){
                factorial2 *= i;
            }

            long producto = factorial1 * factorial2;
            System.out.println("El producto de los factoriales es: " + producto);
        }else{
            System.out.println("Error: al menos uno de los números es negativo.");
        }
    }
}

