// Laboratorio N° 01 - Ejercicio 2
// Autor: Jhossep Fabritzio Velarde Saldaña

import java.util.*;
public class Actividad2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String soldado1, soldado2, soldado3, soldado4, soldado5;
        int vida1, vida2, vida3, vida4, vida5;
        
        System.out.println("Ingrese el nombre del soldado 1: ");
        soldado1 = sc.nextLine();
        vida1 = (int)(Math.random() * (5 - 0 + 1));
        System.out.println("Ingrese el nombre del soldado 2: ");
        soldado2 = sc.nextLine();
        vida2 = (int)(Math.random() * (5 - 0 + 1));
        System.out.println("Ingrese el nombre del soldado 3: ");
        soldado3 = sc.nextLine();
        vida3 = (int)(Math.random() * (5 - 0 + 1));
        System.out.println("Ingrese el nombre del soldado 4: ");
        soldado4 = sc.nextLine();
        vida4 = (int)(Math.random() * (5 - 0 + 1));
        System.out.println("Ingrese el nombre del soldado 5: ");
        soldado5= sc.nextLine();
        vida5 = (int)(Math.random() * (5 - 0 + 1));

        System.out.println();
        System.out.println("Los nombres de los soldados y su vida son los siguientes:");
        System.out.println();
        System.out.println("Soldado 1: " + soldado1 + " - Nivel de vida: " + vida1);
        System.out.println("Soldado 2: " + soldado2 + " - Nivel de vida: " + vida2);
        System.out.println("Soldado 3: " + soldado3 + " - Nivel de vida: " + vida3);
        System.out.println("Soldado 4: " + soldado4 + " - Nivel de vida: " + vida4);
        System.out.println("Soldado 5: " + soldado5 + " - Nivel de vida: " + vida5);
        sc.close();
    }
}
