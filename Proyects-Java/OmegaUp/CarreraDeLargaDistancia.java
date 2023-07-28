import java.util.*;
class CarreraDeLargaDistancia{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int M = sc.nextInt();
    int T = sc.nextInt();
    int U = sc.nextInt();
    int F = sc.nextInt();
    int D = sc.nextInt();

    String[] caminos = new String[T];
    for(int i = 0; i < T; i++){
      caminos[i] = sc.next();
    }

    int maxDistance = distanciaMaxima(M, T, U, F, D, caminos);
    System.out.println(maxDistance);
    sc.close();
  }

  public static int distanciaMaxima(int M, int T, int U, int F, int D, String[] caminos){
    int tiempo = 0;
    int distancia = 0;

    for(int i = 0; i < T; i++){
      if(caminos[i].equals("U") || caminos[i].equals("D")){
        tiempo += U + D;
      }else if(caminos[i].equals("F")){
        tiempo += 2 * F;
      }

      if(tiempo <= M){
        distancia++;
      }else{
        break;
      }
    }
    return distancia;
  }
}
