package nsu.fit.usoltsev.pacmangamenew.Model;

public class Matrix {

    public static final int CELL_SIZE = 24;    //Должно быть четным.
    public static final int CELL_X_COUNT = 28; //Должно быть четным.
    public static final int CELL_Y_COUNT = 32; //Должно быть четным.

    //672*768

    public static final int EMPTY = 0;
    public static final int BORDER = 1;
    public static final int DOT = 2;
    public static final int ELSE = 3;
    public static final int DOT_SCORE = 10;
    public static int MAX_SCORE = 0;

    public static int[][] matrix = new int[CELL_X_COUNT][CELL_Y_COUNT];


    //TODO: create data file
    public static void setMatrix() {
        if (CELL_SIZE % 2 != 0 || CELL_X_COUNT % 2 != 0 || CELL_Y_COUNT % 2 != 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < CELL_X_COUNT; i++) {
            matrix[i][0] = BORDER;
            matrix[i][CELL_Y_COUNT - 1] = BORDER;
        }

        for (int i = 0; i <= 9; i++) {
            matrix[0][i] = BORDER;
            matrix[CELL_X_COUNT - 1][i] = BORDER;
        }
        for (int i = 19; i < CELL_Y_COUNT; i++) {
            matrix[0][i] = 1;
            matrix[CELL_X_COUNT - 1][i] = 1;
        }
        for (int i = 2; i <= 5; i++) {
            for (int j = 2; j <= 4; j++) {
                matrix[i][j] = 1;
                matrix[CELL_X_COUNT - 1 - i][j] = 1;
            }
            for (int j = 6; j <= 7; j++) {
                matrix[i][j] = 1;
                matrix[CELL_X_COUNT - 1 - i][j] = 1;
            }
        }

        for (int i = 0; i <= 5; i++) {
            matrix[i][9] = 1;
            matrix[CELL_X_COUNT - 1 - i][9] = 1;
            matrix[i][13] = 1;
            matrix[CELL_X_COUNT - 1 - i][13] = 1;
            matrix[i][15] = 1;
            matrix[CELL_X_COUNT - 1 - i][15] = 1;
            matrix[i][19] = 1;
            matrix[CELL_X_COUNT - 1 - i][19] = 1;
            for (int j = 10; j <= 12; j++) {
                matrix[i][j] = 3;
                matrix[CELL_X_COUNT - 1 - i][j] = 3;
            }
            for (int j = 16; j <= 18; j++) {
                matrix[i][j] = 3;
                matrix[CELL_X_COUNT - 1 - i][j] = 3;
            }
        }

        for (int j = 9; j <= 13; j++) {
            matrix[5][j] = 1;
            matrix[CELL_X_COUNT - 1 - 5][j] = 1;
        }
        for (int j = 15; j <= 19; j++) {
            matrix[5][j] = 1;
            matrix[CELL_X_COUNT - 1 - 5][j] = 1;
        }

        for (int i = 7; i <= 11; i++) {
            for (int j = 2; j <= 4; j++) {
                matrix[i][j] = 1;
                matrix[CELL_X_COUNT - 1 - i][j] = 1;
            }
        }
        for (int i = 13; i <= 14; i++) {
            for (int j = 0; j <= 4; j++) {
                matrix[i][j] = 1;
            }
            for (int j = 6; j <= 10; j++) {
                matrix[i][j] = 1;
            }
            for (int j = 18; j <= 22; j++) {
                matrix[i][j] = 1;
            }
            for (int j = 24; j <= 28; j++) {
                matrix[i][j] = 1;
            }
        }


        for (int i = 10; i <= 17; i++) {
            for (int j = 6; j <= 7; j++) {
                matrix[i][j] = 1;
            }
            for (int j = 6; j <= 7; j++) {
                matrix[i][j] = 1;
            }
            for (int j = 18; j <= 19; j++) {
                matrix[i][j] = 1;
            }
            for (int j = 24; j <= 25; j++) {
                matrix[i][j] = 1;
            }
            matrix[i][12] = 1;
            matrix[i][16] = 1;
            for (int j = 13; j < 16; j++) {
                matrix[i][j] = 3;
            }
        }

        for (int j = 12; j < 16; j++) {
            matrix[10][j] = 1;
            matrix[17][j] = 1;
        }

        for (int i = 7; i <= 8; i++) {
            for (int j = 6; j <= 13; j++) {
                matrix[i][j] = 1;
                matrix[CELL_X_COUNT - 1 - i][j] = 1;
            }
            for (int j = 15; j <= 19; j++) {
                matrix[i][j] = 1;
                matrix[CELL_X_COUNT - 1 - i][j] = 1;
            }
            for (int j = 24; j <= 28; j++) {
                matrix[i][j] = 1;
                matrix[CELL_X_COUNT - 1 - i][j] = 1;
            }
        }

        for (int i = 0; i <= 2; i++) {
            for (int j = 24; j <= 25; j++) {
                matrix[i][j] = 1;
                matrix[CELL_X_COUNT - 1 - i][j] = 1;
            }
        }
        for (int i = 2; i <= 11; i++) {
            for (int j = 27; j <= 28; j++) {
                matrix[i][j] = 1;
                matrix[CELL_X_COUNT - 1 - i][j] = 1;
            }
        }

        for (int i = 7; i <= 11; i++) {
            for (int j = 21; j <= 22; j++) {
                matrix[i][j] = 1;
                matrix[CELL_X_COUNT - 1 - i][j] = 1;
            }
        }
        for (int i = 2; i <= 5; i++) {
            for (int j = 21; j <= 22; j++) {
                matrix[i][j] = 1;
                matrix[CELL_X_COUNT - 1 - i][j] = 1;
            }
        }
        for (int i = 4; i <= 5; i++) {
            for (int j = 21; j <= 25; j++) {
                matrix[i][j] = 1;
                matrix[CELL_X_COUNT - 1 - i][j] = 1;
            }
        }
    }

}
