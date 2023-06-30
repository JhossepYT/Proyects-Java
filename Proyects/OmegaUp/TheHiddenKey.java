import java.util.*;
class TheHiddenKey{

    public static String encodeString(int n, String str){
        String result = "";

        for (int j = 0; j < n; j++){
            int sum = 0;
            for(int i = j; i < str.length(); i += n){
                sum += str.charAt(i) - 'A' + 1;
            }
            int digit = (sum % 10) + 1;
            result += (char) (digit + '0');
        }
        return result;
    }

    public static String decodeString(int n, String str){
        String result = "";

        for(int i = 0; i < n; i++){
            int digit = str.charAt(i) - '0' - 1;
            char letter = (char)(digit + 'A');
            result += letter;
        }
        return result;
    }

        public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String firstLine = sc.nextLine();
        int firstN = Integer.parseInt(firstLine.substring(1));

        String secondLine = sc.nextLine();

        String thirdLine = sc.nextLine();
        int secondN = Integer.parseInt(thirdLine.substring(1));

        String fourthLine = sc.nextLine();

        String encodedString = encodeString(firstN, secondLine);
        String decodedString = decodeString(secondN, fourthLine);

        System.out.println(encodedString + "-" + decodedString);
    }
}
