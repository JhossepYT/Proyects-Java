import java.util.*;
class Will1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la dificultad: ");
        int dificultad = sc.nextInt();
        double r = Math.random();
        int random = (int)r * dificultad + 1;
        System.out.println("Trata de adivinar que numero tengo guardado: ");
        int numero = sc.nextInt();
        System.out.println("Nivel de dificultad: " + dificultad);
        System.out.println("Número generado: " + random);
        System.out.println("Número ingresado: " + numero);
        int conta_user = 0;
        int conta_pc = 0;
        sc.close();

        for(int i = 0; i > 0; i++){
            if(random == numero){
                conta_user++;
            }else{
                conta_pc++;
            }
        }

        if(conta_user > conta_pc){
            System.out.println("Ganaste");
        }else{
            System.out.println("Gana PC");
        }

        System.out.println("La PC gano: " + conta_pc);
        System.out.println("Usted gano: " + conta_user);
        if(conta_pc == conta_user){
            System.out.println("Empate");
        }else{
            if(conta_user > conta_pc){
                System.out.println("Ganaste");
            }else{
                System.out.println("Gano la PC");
            }
        }
    }
}