import java.util.*;
class Patrones{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String patron = sc.nextLine();
        int textL = text.length();
        int patronL = patron.length();
        
        for(int i = 0; i <= textL - patronL; i++){
            int j = 0;
            while(j < patronL && text.charAt(i + j) == patron.charAt(j)){
                j++;
            }
            if(j == patronL){
                int startPosition = i + 1;
                System.out.println(startPosition);
            }
        }
    }
}
