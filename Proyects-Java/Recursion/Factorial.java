import java.util.*;
class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(factorial(sc.nextInt()));
        sc.close();
    }

    public static int factorial(int i){
        if(i == 0){
            return 1;
        }
        System.out.println(i);
        return factorial(i - 1) * i;
    }
}
