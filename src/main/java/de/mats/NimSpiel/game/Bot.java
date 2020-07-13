package de.mats.NimSpiel.game;

import java.io.Serializable;
import java.util.Random;


public class Bot implements Serializable {

    private final String Name = "Bot" + new Random().nextInt(100000 - 1) + 1;

    public String getName() {
        return Name;
    }

    public int[] getTurn(Spielfeld spielfeld) {
        int[][] feld = spielfeld.get(), testFeld = new int[feld.length - 1][2];
        //turn[0]: Reihe | turn[1]: Str
        final int[] turn = {0, 0};

        if (solve(feld) != 0) {
            for (int i = 0; i < feld.length; i++) {
                for (int j = 0, x = 0; j < feld.length; j++) {
                    if (i == j) continue;
                    testFeld[x][0] = feld[j][0];
                    testFeld[x][1] = feld[j][1];
                    x++;
                }
                int val = solve(testFeld);
                if (val == 0) continue;
                int diff = feld[i][0] - val;

                if (val < 1 || val > 3) continue;
                if (diff < 0) continue;


                turn[0] = i + 1;
                turn[1] = val;
            }
        } else {
            for (int a = 0; a < feld.length; a++) {
                if (feld[a][0] != 0) {
                    do {
                        turn[1] = new Random().nextInt(3 - 1) + 1;
                    } while (!(feld[a][0] >= turn[1]));
                    turn[0] = a + 1;
                }
            }
        }

        if (turn[0] == 0 || turn[1] == 0) {
            for (int i = 0; i < feld.length; i++) {
                if (feld[i][0] != 0) {
                    if (!(feld[i][0] > 3 || feld[i][0] < 1)) {
                        turn[0] = i + 1;
                        turn[1] = feld[i][0];
                        break;
                    }
                }
            }
        }
        return turn;
    }


    private int solve(int[][] feld) {
        final int MAX_BIT_COUNT = 8;
        int[] lineModulo = new int[feld.length];
        for (int i = 0; i < feld.length; i++) {
            lineModulo[i] = feld[i][0] % (3 + 1);
        }
        int[][] binaryColumns = new int[lineModulo.length][MAX_BIT_COUNT];
        for (int i = 0; i < lineModulo.length; i++) {
            for (int j = 0; j < MAX_BIT_COUNT; j++) {
                binaryColumns[i][j] = (lineModulo[i] >> j) & 1;
            }
        }
        int solveable = 0;
        for (int i = 0; i < MAX_BIT_COUNT; i++) {
            int columSum = 0;
            for (int j = binaryColumns.length - 1; j >= 0; j--) {
                columSum += binaryColumns[j][i];
            }

            solveable |= ((columSum & 1) << i);
        }
        return solveable;
    }
}