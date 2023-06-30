import java.util.*;
class ExtravagantVersioning{
    public static int romanToDecimal(String roman){
        int decimal = 0;
        int antValue = 0;

        for(int i = 0; i < roman.length(); i++){
            char currentChar = roman.charAt(i);
            int currentValue = getRomanValue(currentChar);

            if(currentValue > antValue){
                decimal += currentValue - 2 * antValue;
            }else{
                decimal += currentValue;
            }
            antValue = currentValue;
        }
        return decimal;
    }

    public static int getRomanValue(char romanChar){
        if(romanChar == 'I'){
            return 1;
        }else if(romanChar == 'V'){
            return 5;
        }else if(romanChar == 'X'){
            return 10;
        }else if(romanChar == 'L'){
            return 50;
        }else if(romanChar == 'C'){
            return 100;
        }else if(romanChar == 'D'){
            return 500;
        }else if(romanChar == 'M'){
            return 1000;
        }else{
            System.out.println("Carácter romano inválido, checa bien: " + romanChar);
            return 0;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numVersions = sc.nextInt();
        sc.nextLine(); //BUG//

        for(int i = 0; i < numVersions; i++){
            String version = sc.nextLine();
            int decimal = romanToDecimal(version);
            System.out.println(decimal);
        }
    }
}