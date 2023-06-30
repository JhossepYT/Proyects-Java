import java.util.*;
class TheHiddenKey {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n1Line = sc.nextLine();
        String l1Line = sc.nextLine();
        String n2Line = sc.nextLine();
        String l2Line = sc.nextLine();
        
        int n1 = Integer.parseInt(n1Line.substring(2));
        String l1 = l1Line.substring(2);
        int n2 = Integer.parseInt(n2Line.substring(2));
        String l2 = l2Line.substring(2);
        
        String p = calculateP(n1, l1);
        String o = calculateO(n2, l2);
        
        String result = p + " - " + o;
        System.out.println(result);
        sc.close();
    }
    
    public static String calculateP(int n, String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i += n) {
            String substring = input.substring(i, i + n);
            int sum = 0;
            for (char c : substring.toCharArray()) {
                int value = c - 'A' + 1;
                sum += value;
            }
            int digit = (sum + 1) % 10;
            sb.append(digit);
        }
        return sb.toString();
    }
    
    public static String calculateO(int n, String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i += n) {
            String substring = input.substring(i, i + n);
            int sum = 0;
            for (char c : substring.toCharArray()) {
                int value = c - 'A' + 1;
                sum += value;
            }
            int digit = (sum + 1) % 10;
            char letter = (char) (digit + 'A' - 1);
            sb.append(letter);
        }
        return sb.toString();
    }
}