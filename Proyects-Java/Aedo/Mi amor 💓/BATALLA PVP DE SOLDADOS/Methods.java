class Methods {
    public static void mostrarTablero(Soldado[][] tablero) {
        // Imprimir parte de arriba de columnas
        System.out.print("  ");
        for (int j = 0; j < 10; j++) {
            System.out.print("  " + j);
        }
        System.out.println();

        for (int i = 0; i < 10; i++) {
            // Imprimir los números de las filas
            System.out.print(i + "  ");
            for (int j = 0; j < 10; j++) {
                if (tablero[i][j] == null) {
                    System.out.print("|_|");
                } else {
                    System.out.print("|" + tablero[i][j].getTeam() + "|");
                }
            }
            System.out.println();
        }
    }

    public static void verify(Soldado[][] tablero, int x, int y, int x1, int y1) {
        // Verificar si hay un soldado en la posición (x, y)
        if (tablero[x][y] == null) {
            System.out.println("No hay un soldado en la posición (" + x + ", " + y + ")");
            return;
        }

        Soldado soldado = tablero[x][y];
        Soldado otroSoldado = tablero[x1][y1];

        if (otroSoldado == null) {
            // Mover el soldado a la nueva posición vacía
            tablero[x1][y1] = soldado;
            soldado.setFila(x1);
            soldado.setColumna(y1);
            tablero[x][y] = null;
            System.out.println("El soldado " + soldado.getName() + "(" + x + ", " + y + ") se ha movido a (" + x1 + ", "
                    + y1 + ")");
        } else if (soldado.getTeam() == otroSoldado.getTeam()) {
            System.out.println("Ya existe un aliado en la ubicación seleccionada");
        } else {
            // Calcular winrate
            double winRateSoldado = Math.round(calculateWinRate(soldado, otroSoldado));
            double winRateOtroSoldado = Math.round(calculateWinRate(otroSoldado, soldado));

            System.out.println("Porcentaje de winrate del soldado (" + x + ", " + y + "): " + winRateSoldado + "%");
            System.out.println("Porcentaje de winrate del soldado (" + x1 + ", " + y1 + "): " + winRateOtroSoldado + "%");

            // Elegir el real winner
            if (winRateSoldado > winRateOtroSoldado) {
                tablero[x1][y1] = soldado;
                System.out.println(
                        "El soldado " + soldado.getName() + "en la posición (" + x + ", " + y + ") gano el combate");
                // Mover al soldado ganador a la nueva posición
                soldado.setFila(x1);
                soldado.setColumna(y1);
                soldado.setActHP(soldado.getActHP() + 50);
                tablero[x][y] = null;
            } else {
                tablero[x1][y1] = otroSoldado;
                System.out.println("El soldado " + otroSoldado.getName() + " en la posición(" + x1 + ", " + y1 + ") gano el combate");
                // Mover al soldado ganador a la nueva posición
                otroSoldado.setFila(x1);
                otroSoldado.setColumna(y1);
                otroSoldado.setActHP(otroSoldado.getActHP() + 50);
                tablero[x][y] = null;
            }
        }
    }

    private static double calculateWinRate(Soldado soldado, Soldado otroSoldado) {
        double vidaSoldado = soldado.getActHP();
        double vidaOtroSoldado = otroSoldado.getActHP();
        double atkSoldado = soldado.getAtkLvl();
        double atkOtroSoldado = otroSoldado.getAtkLvl();

        double winRate = (vidaSoldado + atkSoldado) / (vidaSoldado + atkSoldado + vidaOtroSoldado + atkOtroSoldado)
                * 100;
        return winRate;
    }

    public static int calcularSumaVidaEquipo(Soldado[][] tablero, int equipo) {
        int sumaVida = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Soldado s = tablero[i][j];
                if (s != null && s.getTeam() == equipo) {
                    sumaVida += s.getActHP();
                }
            }
        }
        return sumaVida;
    }
}