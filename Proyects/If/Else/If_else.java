import java.util.*;
class If_else{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Es un dia laborable?");
        boolean esDiaLaborable = sc.nextBoolean();
        System.out.println("¿Estas de vacaciones?");
        boolean estasDeVacaciones = sc.nextBoolean();
        sc.close();

        if(estasDeVacaciones || esDiaLaborable){
            System.out.println("Puedes dormir tarde");
        }else{
            System.out.println("No puedes dormir tarde");
        }
    }
}