import java.util.*;
class PizzaProblem{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mayorCoin = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            int coin = sc.nextInt();
            if(coin > mayorCoin){
                mayorCoin = coin;
            }
        }

        int result = mayorCoin * (mayorCoin + 2);
        if(result % 2 == 0){
            System.out.println("hawaiiana");
        }else{
            System.out.println("pepperoni");
        }
    }
}