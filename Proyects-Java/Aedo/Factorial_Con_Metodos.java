import java.util.*;
class Factorial_Con_Metodos{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el primer número: ");
        int num1 = sc.nextInt();
        System.out.print("Ingrese el segundo número: ");
        int num2 = sc.nextInt();
        long factorial1 = factorial(num1);
        long factorial2 = factorial(num2);
        sc.close();

        if(factorial1 != -1 && factorial2 != -1){
            long producto = factorial1 * factorial2;
            System.out.println("El producto de los factoriales es: " + producto);
        }else{
            System.out.println("Error: al menos uno de los números es negativo.");
        }
    }

    public static long factorial(int num){
        if(num < 0){
            return - 1; //error si el número es negativo//
        }

        long factorial = 1;
        for (int i = 1; i <= num; i++){
            factorial *= i;
        }
        return factorial;
    }
}
