import java.util.*;

public class Batalla {
    public static void main(String[] args) {
        System.out.println();
        // Inicializar tablero
        Soldado[][] tablero = new Soldado[10][10];

        int n = 10;
        // Army 1
        for (int i = 0; i < n; i++) {
            Soldado s = new Soldado();
            s.setName("SoldadoEj1_" + i);
            s.setHp((int) (Math.random() * (5 - 1 + 1) + 1));
            s.setActHP((int) (Math.random() * (5 - 1 + 1) + 1));
            int fila, col;
            do {
                fila = (int) (Math.random() * 10);
                col = (int) (Math.random() * 10);
            } while (tablero[fila][col] != null);
            s.setFila(fila);
            s.setColumna(col);
            s.setTeam(1);
            tablero[fila][col] = s;
        }

        // Army 2
        for (int i = 0; i < n; i++) {
            Soldado s = new Soldado();
            s.setName("SoldadoEj2_" + i);
            s.setHp((int) (Math.random() * (5 - 1 + 1) + 1));
            s.setActHP((int) (Math.random() * (5 - 1 + 1) + 1));
            int fila, col;
            do {
                fila = (int) (Math.random() * 10);
                col = (int) (Math.random() * 10);
            } while (tablero[fila][col] != null);
            s.setFila(fila);
            s.setColumna(col);
            s.setTeam(2);
            tablero[fila][col] = s;
        }

        // Mostrar tablero
        Methods.mostrarTablero(tablero);
        // Soldado con mayor vida de cada ejército
        Soldado mayorVidaEj1 = null;
        Soldado mayorVidaEj2 = null;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Soldado s = tablero[i][j];
                if (s != null) {
                    if (s.getName().startsWith("SoldadoEj1_")
                            && (mayorVidaEj1 == null || s.getHp() > mayorVidaEj1.getHp())) {
                        mayorVidaEj1 = s;
                    }
                    if (s.getName().startsWith("SoldadoEj2_")
                            && (mayorVidaEj2 == null || s.getHp() > mayorVidaEj2.getHp())) {
                        mayorVidaEj2 = s;
                    }
                }
            }
        }

        System.out.println();
        System.out.println("--------------------------------------------------------");
        System.out.println();
        System.out.println("Soldado con mayor vida Ejército 1:");
        System.out.println(mayorVidaEj1);
        System.out.println();
        System.out.println("--------------------------------------------------------");
        System.out.println();
        System.out.println("Soldado con mayor vida Ejército 2:");
        System.out.println(mayorVidaEj2);

        // Promedio vida de cada ejército
        int countEj1 = 0, countEj2 = 0;
        int sumaEj1 = 0, sumaEj2 = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Soldado s = tablero[i][j];
                if (s != null) {
                    if (s.getName().startsWith("SoldadoEj1_")) {
                        sumaEj1 += s.getHp();
                        countEj1++;
                    } else {
                        sumaEj2 += s.getHp();
                        countEj2++;
                    }
                }
            }
        }

        double promEj1 = (double) sumaEj1 / countEj1;
        double promEj2 = (double) sumaEj2 / countEj2;

        System.out.println();
        System.out.println("--------------------------------------------------------");
        System.out.println();
        System.out.println("Promedio vida Ejército 1: " + promEj1);
        System.out.println("Promedio vida Ejército 2: " + promEj2);

        // Soldados por orden de creación
        ArrayList<Soldado> soldadosEj1 = new ArrayList<>();
        ArrayList<Soldado> soldadosEj2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Soldado s = tablero[i][j];
                if (s != null) {
                    if (s.getName().startsWith("SoldadoEj1_")) {
                        soldadosEj1.add(s);
                    } else {
                        soldadosEj2.add(s);
                    }
                }
            }
        }

        System.out.println();
        System.out.println("--------------------------------------------------------");
        System.out.println();
        System.out.println("Soldados Ejército 1:");
        for (Soldado s : soldadosEj1) {
            System.out.println(s);
        }

        System.out.println();
        System.out.println("--------------------------------------------------------");
        System.out.println();
        System.out.println("Soldados Ejército 2:");
        for (Soldado s : soldadosEj2) {
            System.out.println(s);
        }

        // Ranking de poder
        ArrayList<Soldado> soldadosEj1Sorted = new ArrayList<>(soldadosEj1);
        ArrayList<Soldado> soldadosEj2Sorted = new ArrayList<>(soldadosEj2);

        // Ordenamiento por selección
        for (int i = 0; i < soldadosEj1Sorted.size(); i++) {
            int maxIndex = i;
            for (int j = i + 1; j < soldadosEj1Sorted.size(); j++) {
                if (soldadosEj1Sorted.get(j).getHp() > soldadosEj1Sorted.get(maxIndex).getHp()) {
                    maxIndex = j;
                }
            }
            Soldado temp = soldadosEj1Sorted.get(maxIndex);
            soldadosEj1Sorted.set(maxIndex, soldadosEj1Sorted.get(i));
            soldadosEj1Sorted.set(i, temp);
        }

        for (int i = 0; i < soldadosEj2Sorted.size(); i++) {
            int maxIndex = i;
            for (int j = i + 1; j < soldadosEj2Sorted.size(); j++) {
                if (soldadosEj2Sorted.get(j).getHp() > soldadosEj2Sorted.get(maxIndex).getHp()) {
                    maxIndex = j;
                }
            }
            Soldado temp = soldadosEj2Sorted.get(maxIndex);
            soldadosEj2Sorted.set(maxIndex, soldadosEj2Sorted.get(i));
            soldadosEj2Sorted.set(i, temp);
        }

        System.out.println();
        System.out.println("--------------------------------------------------------");
        System.out.println();
        System.out.println("Ranking Ejército 1:");
        for (Soldado s : soldadosEj1Sorted) {
            System.out.println(s);
        }

        System.out.println();
        System.out.println("--------------------------------------------------------");
        System.out.println();
        System.out.println("Ranking Ejército 2:");
        for (Soldado s : soldadosEj2Sorted) {
            System.out.println(s);
        }

        // Select winner
        int sumaVidaEj1 = 0;
        for (Soldado s : soldadosEj1Sorted) {
            sumaVidaEj1 += s.getHp();
        }

        int sumaVidaEj2 = 0;
        for (Soldado s : soldadosEj2Sorted) {
            sumaVidaEj2 += s.getHp();
        }

        System.out.println();
        System.out.println("--------------------------------------------------------");
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println();
        System.out.println("EN BASE A LOS PUNTOS DE VIDA:");
        System.out.println();
        if (sumaVidaEj1 > sumaVidaEj2) {
            System.out.println("Gana el Ejército 1");
        } else if (sumaVidaEj2 > sumaVidaEj1) {
            System.out.println("Gana el Ejército 2");
        } else {
            System.out.println("Empate");
        }
        System.out.println();
        System.out.println("----------------------------------------------------");

        System.out.println("¡Bienvenidos al Juego de Batallas de Soldados PVP!");
        System.out.println();
        System.out.println("Reglas del Juego:");
        System.out.println("1. PvP (Jugador contra Jugador): Dos ejércitos se enfrentan en un tablero de 10x10.");
        System.out.println("2. Objetivo: El ejército que quede con soldados en el campo gana.");
        System.out.println("3. Movimiento: Selecciona un soldado y una nueva posición.");
        System.out.println("4. Combate: Si la nueva posición tiene un enemigo, se combate.");
        System.out.println("   - Winrate (porcentaje de victoria) se calcula como:");
        System.out.println(
                "     winRate = (vidaSoldado + atkSoldado) / (vidaSoldado + atkSoldado + vidaOtroSoldado + atkOtroSoldado) * 100");
        System.out.println("   - El soldado con mayor winrate gana el combate.");
        System.out.println("   - El ganador se mueve y gana 1 punto de vida.");
        System.out.println("   - El perdedor es eliminado.");
        System.out.println();
        System.out.println("¡Buena Suerte! ¡Que comience el juego!");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        boolean gameOver = false;
        while (!gameOver) {
            Methods.mostrarTablero(tablero);
            int x, y, x1, y1;

            while (true) {
                System.out.println("Ingrese las coordenadas del soldado a seleccionar (x, y):");
                System.out.print("x: ");
                x = sc.nextInt();
                System.out.print("y: ");
                y = sc.nextInt();

                System.out.println("Ingrese las nuevas coordenadas (x1, y1):");
                System.out.print("x1: ");
                x1 = sc.nextInt();
                System.out.print("y1: ");
                y1 = sc.nextInt();

                if (x >= 0 && x < 10 && y >= 0 && y < 10 && x1 >= 0 && x1 < 10 && y1 >= 0 && y1 < 10) {
                    if (tablero[x][y] != null) {
                        break;
                    } else {
                        System.out.println("No hay un soldado en la posición inicial. Intente de nuevo.");
                        Methods.mostrarTablero(tablero);
                    }
                } else {
                    System.out.println("Coordenadas fuera de rango. Intente de nuevo.");
                    Methods.mostrarTablero(tablero);
                }
            }
            Methods.verify(tablero, x, y, x1, y1);
            // Verificar si el juego ha terminado
            int sumaVid1 = Methods.calcularSumaVidaEquipo(tablero, 1);
            int sumaVid2 = Methods.calcularSumaVidaEquipo(tablero, 2);
            if (sumaVid1 == 0) {
                Methods.mostrarTablero(tablero);
                System.out.println("El Ejercito 2 gana la batalla");
                gameOver = true;
            } else if (sumaVid2 == 0) {
                Methods.mostrarTablero(tablero);
                System.out.println("El Ejercito 1 gana la batalla");
                gameOver = true;
            }
        }
        sc.close();
    }
}