import java.util.*;
class ModoDrama{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Nikole esta aburrida?");
        boolean resp = sc.nextBoolean();
        System.out.println("¿Mañana hay clase?");
        boolean resp2 = sc.nextBoolean();
        sc.close();

        if(resp==true&&resp2==false||resp==false&&resp2==false){
            System.out.println("Modo Drama Activado");
        }else{
            System.out.println("Modo Drama Desactivado");
        }
    }
}