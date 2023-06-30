import java.util.*;
class CR_A_Contar_2{

    public static int checker(String compText){
        int suma = 0;

        for(int i = 0; i < compText.length(); i++){
            char c = compText.charAt(i);
            if(c >= '0' && c <= '9'){
                int digit = c - '0';
                suma += digit;
            }
        }
        return suma;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        int result = checker(text);
        System.out.println(result);
    }
}