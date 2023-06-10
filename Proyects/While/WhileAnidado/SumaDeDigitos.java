import java.util.*;
class SumaDeDigitos{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un número: ");
        
        String numero = sc.nextLine();
        System.out.println("Explicacion: ");
        int cantidad = numero.length();
        while(cantidad > 1){
            int suma = 0;

            int i = 0;
            while(i < cantidad){
                char cifra = numero.charAt(i);
                suma += Integer.parseInt(Character.toString(cifra));
                System.out.print(cifra);
                if(i != cantidad - 1){
                    System.out.print("+");
                }
                
                i++;
            }
            numero = suma + "";
            cantidad = numero.length();
            System.out.print("->" + suma + " ");
        }
        sc.close();        
    }
}