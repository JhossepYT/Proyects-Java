import java.util.*;
class While{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el multiplicando");
        int multiplicando = sc.nextInt();
        System.out.println("Ingrese el multiplicador");
        int multiplicador = sc.nextInt();
        sc.close();
        
        int producto = 0;
        

        int i = 0;
        while(i < multiplicador){
            producto = producto + multiplicando;
            i++;
        }

        System.out.printf("%d x %d = %d\n", multiplicando, multiplicador, producto);

    }
}