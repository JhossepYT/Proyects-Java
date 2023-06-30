import java.util.*;
class ParityBit{

    public static int countOnes(String sequence){
        int count = 0;
        for(int i = 0; i < sequence.length(); i++){
            if(sequence.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }

        public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String secuencia = sc.nextLine();
        int onesCount = countOnes(secuencia);

        int bitdeparidad = 0;
        if (onesCount % 2 != 0){
            bitdeparidad = 1;
        }
        String result = secuencia + bitdeparidad;
        System.out.println(result);
    }
}