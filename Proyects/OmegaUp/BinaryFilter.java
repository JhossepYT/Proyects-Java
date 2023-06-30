import java.util.*;
class BinaryFilter{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String imput = sc.nextLine();
        String magic;

        if(isBinary(imput)){
            magic = imput;
        }else{
            magic = "10101";
        }
        System.out.println(magic);
        sc.close();
    }

    public static boolean isBinary(String message){
        for(int i = 0; i < message.length(); i++){
            char c = message.charAt(i);
            if(c != '0' && c != '1'){
                return false;
            }
        }
        return true;
    }
}