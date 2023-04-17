package nsu.fit.usoltsev.pacmangamenew.View;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import nsu.fit.usoltsev.pacmangamenew.Model.*;

public class FieldView {

    private Rectangle createBorder(int x, int y, float offsetX, float offsetY) {
        Rectangle rect = new Rectangle((float) Matrix.CELL_SIZE / 2, (float) Matrix.CELL_SIZE / 2);
        rect.setFill(Color.BLACK);
        rect.setStroke(Color.BLUE);
        rect.setX((x + offsetX) * Matrix.CELL_SIZE);
        rect.setY((y + offsetY) * Matrix.CELL_SIZE);
        return rect;
    }

    public void drawBorders(AnchorPane root, int[][] matrix) {
        for (int i = 0; i < Matrix.CELL_X_COUNT; i++) {
            for (int j = 0; j < Matrix.CELL_Y_COUNT; j++) {
                if (matrix[i][j] == 1) {
                    root.getChildren().add(createBorder(i, j, 0, 0));
                    root.getChildren().add(createBorder(i, j, 0.5f, 0));
                    root.getChildren().add(createBorder(i, j, 0, 0.5f));
                    root.getChildren().add(createBorder(i, j, 0.5f, 0.5f));
                }
            }
        }
    }


}
