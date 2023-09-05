import java.util.*;
class Voltear{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(inverter(sc.nextLine()));
        sc.close();
    }

    public static String inverter(String text){
        String x = "";
        for(int i = text.length() - 1; i >= 0; i--){
            x += text.charAt(i);
        }
        return x;
    }
}