import java.util.*;
class Alex_la_barba_y_las_pyzzas{
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        int dias = sc.nextInt();
        int price = sc.nextInt();
        int total = 0;

        int i = 0;
        while(i < dias){
            int x = sc.nextInt();
            total = total + x * price;
            
            i++;
        }
        System.out.println(total);
        sc.close();
    }
}