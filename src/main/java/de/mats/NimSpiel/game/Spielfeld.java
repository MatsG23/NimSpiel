package de.mats.NimSpiel.game;

import java.io.Serializable;

public class Spielfeld implements Serializable {

    private final int[][] field;

    public Spielfeld(int reihen) {
        field = new int[reihen][2];
        for (int i = 0; i < field.length; i++) {
            field[i][0] = field[i][1] = i + 1;
        }
    }

    int[][] get() {
        return field;
    }

    public String render() {
        String reihen = "";
        int Leerzeichen = 1;
        int Differenz;

        for (int[] ints : field) {
            for (int a = -2; a < field.length - Leerzeichen; a++) {
                reihen = reihen.concat(" ");
            }
            Differenz = ints[1] - ints[0];
            for (int b = 1; b < Leerzeichen + 1; b++) {
                if (Differenz == 0) {
                    reihen = reihen.concat("| ");
                } else {
                    reihen = reihen.concat("X ");
                    Differenz--;
                }
            }
            for (int a = 0; a < field.length - Leerzeichen; a++) {
                reihen = reihen.concat(" ");
            }
            Leerzeichen++;
            reihen = reihen.concat("\n");
        }
        return reihen;
    }

    public boolean isValid(int reihe, int anzahl) {
        return reihe >= 1 && reihe <= field.length && anzahl <= field[reihe - 1][0] && field[reihe - 1][0] != 0;
    }


    public void take(int reihe, int anzahl) {
        field[reihe - 1][0] -= anzahl;
    }

    public boolean isEmpty() {
        int count = 0;
        for (int[] ints : field) {
            count += ints[0];
        }
        return count == 0;
    }
}