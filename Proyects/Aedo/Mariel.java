import java.util.*;
class Prob10{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de notas: ");
        int n = sc.nextInt();
        Double c = 0.0;
        Double prom = 0.0;
        for(int i = 1; i <= n; i++){
            System.out.println("Ingrese la nota " + i + ":");
            Double a = sc.nextDouble();
            c += a;
        }
        prom = c / n;
        if(prom > 10.5){
            System.out.println("Estan aprobados y su promedio es: " + prom);
        }else{
            System.out.println("Estan desaprobados");
        }
    sc.close();
    }
}