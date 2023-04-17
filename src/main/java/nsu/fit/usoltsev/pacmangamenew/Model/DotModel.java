package nsu.fit.usoltsev.pacmangamenew.Model;

import javafx.scene.layout.AnchorPane;
import nsu.fit.usoltsev.pacmangamenew.View.DotView;

public class DotModel {
    static DotView dotView;

    public static void setDots(AnchorPane root) {
        dotView = new DotView(root);
        Matrix.MAX_SCORE = 0;
        for (int i = 0; i < Matrix.CELL_X_COUNT; i++) {
            for (int j = 0; j < Matrix.CELL_Y_COUNT; j++) {
                if (Matrix.matrix[i][j] != Matrix.BORDER && Matrix.matrix[i][j] != Matrix.ELSE) {
                    Matrix.matrix[i][j] = Matrix.DOT;
                    Matrix.MAX_SCORE += Matrix.DOT_SCORE;
                    dotView.appendToDotList(i, j);
                }
            }
        }
    }

    public static void removeDot(int xPos, int yPos) {
        Matrix.matrix[xPos][yPos] = Matrix.EMPTY;
        dotView.removeFromDotList(xPos, yPos);
    }

}
