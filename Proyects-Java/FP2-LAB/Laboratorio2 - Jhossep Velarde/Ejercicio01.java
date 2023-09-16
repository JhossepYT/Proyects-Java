//Laboratorio N° 02 - Ejercicio 1
//Autor: Jhossep Fabritzio Velarde Saldaña
import java.util.*;
public class Ejercicio01 {
    public static void main(String[] args) {
        String ahor1 = " +---+ \n" +
                       " |   | \n" +
                       "     | \n" +
                       "     | \n" +
                       "     | \n" +
                       "     | \n" +
                       "========= ";
        String ahor2 = " +---+ \n" +
                       " |   | \n" +
                       " O   | \n" +
                       "     | \n" +
                       "     | \n" +
                       "     | \n" +
                       "=========";

        String ahor3 = " +---+ \n" +
                       " |   | \n" +
                       " O   | \n" +
                       " |   | \n" + 
                       "     | \n" +
                       "     | \n" +
                       "=========";

        String ahor4 = " +---+ \n" +
                       " |   | \n" +
                       " O   | \n" +
                       "/|   | \n" +
                       "     | \n" +
                       "     | \n" +
                       "=========";

        String ahor5 = " +---+ \n" +
                       " |   | \n" +
                       " O   | \n" +
                       "/|\\  | \n" +
                       "     | \n" +
                       "     | \n" +
                       "=========";

        String ahor6 = " +---+ \n" +
                       " |   | \n" +
                       " O   | \n" +
                       "/|\\  | \n" +
                       "/    | \n" +
                       "     | \n" +
                       "=========";

        String ahor7 = " +---+ \n" +
                       " |   | \n" +
                       " O   | \n" +
                       "/|\\  | \n" +
                       "/ \\  | \n" +
                       "     | \n" +
                       "=========";

        String[] figuras = { ahor1, ahor2, ahor3, ahor4, ahor5, ahor6, ahor7 };
        int contador = 0;
        String letra;
        String[] palabras = { "programacion", "java", "indentacion", "clases",
                "objetos", "desarrollador", "pruebas", "test", "pruebita", "uwu" };
        String palSecreta = getPalabraSecreta(palabras);
        int letrasRestantes = palSecreta.length();

        System.out.println(figuras[contador]);
        char[] palabraMostrada = new char[palSecreta.length()];
        for (int i = 0; i < palabraMostrada.length; i++){
            palabraMostrada[i] = '_';
        }
        mostrarPalabra(palabraMostrada);
        boolean[] letrasAdivinadas = new boolean[26];

        while(contador < 6 && letrasRestantes > 0){
            letra = ingreseLetra();
            char letraChar = letra.charAt(0);
            if(letrasAdivinadas[letraChar - 'a']){
                System.out.println("Ya has ingresado la letra " + letra);
            }else{
                letrasAdivinadas[letraChar - 'a'] = true;
                if(letraEnPalabraSecreta(letra, palSecreta, palabraMostrada)){
                    mostrarPalabra(palabraMostrada);
                    letrasRestantes = contarLetrasRestantes(palabraMostrada);
                }else{
                    contador++;
                    System.out.println(figuras[contador]);
                }
            }
        }

        if(letrasRestantes == 0){
            System.out.println("\n¡Ganaste! La palabra secreta es: " + palSecreta);
        }else{
            System.out.println("\n¡Perdiste! La palabra secreta era: " + palSecreta);
        }
    }

    public static String getPalabraSecreta(String[] lasPalabras){
        int ind;
        int indiceMayor = lasPalabras.length - 1;
        int indiceMenor = 0;
        ind = (int) (Math.random() * (indiceMayor - indiceMenor + 1)) + indiceMenor;
        return lasPalabras[ind];
    }

    public static int contarLetrasRestantes(char[] palabraMostrada){
        int contador = 0;
        for(char c : palabraMostrada){
            if (c == '_'){
                contador++;
            }
        }
        return contador;
    }

    public static void mostrarPalabra(char[] palabra){
        for(char c : palabra){
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static String ingreseLetra(){
        String laLetra;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese letra: ");
        laLetra = sc.next().toLowerCase();
        while (laLetra.length() != 1 || checker(laLetra)){
            System.out.println("Ingrese una sola letra: ");
            laLetra = sc.next().toLowerCase();
        }
        return laLetra;
    }

    public static boolean letraEnPalabraSecreta(String letra, String palSecreta, char[] palabraMostrada){
        boolean letraAdivinada = false;
        for(int i = 0; i < palSecreta.length(); i++){
            if(palSecreta.charAt(i) == letra.charAt(0)){
                if(palabraMostrada[i] == '_'){
                    palabraMostrada[i] = letra.charAt(0);
                    letraAdivinada = true;
                }
            }
        }
        return letraAdivinada;
    }

    public static void actualizarPalabra(String letra, String palSecreta, char[] palabraMostrada){
        for(int i = 0; i < palSecreta.length(); i++){
            if(palSecreta.charAt(i) == letra.charAt(0)){
                palabraMostrada[i] = letra.charAt(0);
            }
        }
    }

    public static boolean checker(String letra){
        String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        for(String letraAbc : abc){
            if(letraAbc.equals(letra)){
                return false;
            }
        }
        return true;
    }
}