import java.util.*;
class Mes{
    public static void main(String[] args) {
        System.out.print(total());
    }

    public static int total(){
        Scanner sc = new Scanner(System.in);
        final int v = 1;
        final int l = 2;
        final int m = 4;
        final int j = 3;
        int total = 0;
        String dias[] = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};

        for(int i = 0; i < 6; i++){
            System.out.println("Ingrese la cantidad de dias " + dias[i]);
            int x = sc.nextInt();
            switch (i){
                case 0: total += x * l;
                        break;
                case 1: total += x * l;
                        break;
                case 2: total += x * m;
                        break;
                case 3: total += x * j;
                        break;
                case 4: total += x * v;
                        break;
                case 5: total += x * l;
                        break; 
            }
        }
        sc.close();
        return total;
    }
}