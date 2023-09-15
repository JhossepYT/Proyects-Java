// Laboratorio N° 01 - Ejercicio 4
// Autor: Jhossep Fabritzio Velarde Saldaña

import java.util.*;
public class Actividad4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nombres = new String[5];
        int[] vida = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Ingresa el nombre del soldado " + (i + 1) + ": ");
            nombres[i] = sc.nextLine();
            System.out.print("Ingresa el nivel de vida del soldado " + (i + 1) + ": ");
            vida[i] = sc.nextInt();
            sc.nextLine();
        }
        System.out.println();
        System.out.println("Los nombres de los soldados y su vida son los siguientes:");
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.println("Soldado " + (i + 1) + ": " + nombres[i] + " - Nivel de vida: " + vida[i]);
        }
        sc.close();
    }
}
