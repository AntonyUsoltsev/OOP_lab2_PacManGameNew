package nsu.fit.usoltsev.pacmangamenew.Model;

import java.io.*;

public class Matrix {

    public static final int CELL_SIZE = 24;    //Должно быть четным.
    public static int CELL_X_COUNT = 28, CELL_Y_COUNT = 32; //Должно быть четным.
    //672*768
    public static final int EMPTY = 0, BORDER = 1, DOT = 2, ELSE = 3, DOT_SCORE = 10;
    public static int MAX_SCORE = 0;

    public static int X_SPAWN, Y_SPAWN;

    public static int[][] matrix = new int[CELL_X_COUNT][CELL_Y_COUNT];

    public static void setMatrix() {
        if (CELL_SIZE % 2 != 0) {
            throw new IllegalArgumentException("Bad cell size");
        }

        if (CELL_X_COUNT % 2 == 0) {
            X_SPAWN = CELL_SIZE * CELL_X_COUNT / 2;
        } else {
            X_SPAWN = CELL_SIZE * (CELL_X_COUNT + 1) / 2;
        }

        if (CELL_Y_COUNT % 2 == 0) {
            Y_SPAWN = CELL_SIZE *( CELL_Y_COUNT / 2 + 1);
        } else {
            Y_SPAWN = CELL_SIZE * ((CELL_Y_COUNT + 1) / 2);
        }

        try (BufferedReader matrixFile = new BufferedReader(new FileReader("./src/main/resources/nsu/fit/usoltsev/pacmangamenew/matrix.txt"))) {
            for (int i = 0; i < CELL_Y_COUNT; i++) {
                String line = matrixFile.readLine();
                String[] values = line.split(" ");
                for (int j = 0; j < CELL_X_COUNT; j++) {
                    matrix[j][i] = Integer.parseInt(values[j]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
