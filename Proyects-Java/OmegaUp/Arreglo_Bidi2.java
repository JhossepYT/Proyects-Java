import java.util.*;
class Arreglo_Bidi2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] num = new int[n][n];
        
        for(int fila = 0; fila < n; fila++){
            for(int columna = 0; columna < n; columna++){
                num[fila][columna] = fila * columna;
            }
        }
        
        for(int fila = 0; fila < n; fila++){
            for(int columna = 0; columna < n; columna++){
                System.out.print(num[fila][columna]);
            }
            System.out.println();
        }
        sc.close();
    }
}
