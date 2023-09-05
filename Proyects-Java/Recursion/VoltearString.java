import java.util.*;
class VoltearString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(voltear(sc.nextLine()));
        sc.close();
    }

    public static String voltear(String text){
        if(text == ""){
            return text;
        }
        System.out.println(text);
        return voltear(text.substring(1)) + text.charAt(0);
    }
}
