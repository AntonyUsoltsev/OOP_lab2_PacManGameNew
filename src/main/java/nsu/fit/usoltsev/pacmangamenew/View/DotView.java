package nsu.fit.usoltsev.pacmangamenew.View;

import nsu.fit.usoltsev.pacmangamenew.Model.*;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;

public class DotView {
    HashMap<Integer, Rectangle> dotList;
    AnchorPane root;

    public DotView(AnchorPane root) {
        this.root = root;
        dotList=new HashMap<>();
    }

    public void appendToDotList(int x, int y) {

        Rectangle dot = new Rectangle(Matrix.CELL_SIZE / 4, Matrix.CELL_SIZE / 4);
        dot.setFill(Color.WHITE);
        dot.setX(x * Matrix.CELL_SIZE + (Matrix.CELL_SIZE - Matrix.CELL_SIZE / 4) / 2);
        dot.setY(y * Matrix.CELL_SIZE + (Matrix.CELL_SIZE - Matrix.CELL_SIZE / 4) / 2);
        dotList.put(y * Matrix.CELL_X_COUNT + x, dot);
        root.getChildren().add(dot);
    }

    public void removeFromDotList(int x, int y) {
        root.getChildren().remove( dotList.get(y * Matrix.CELL_X_COUNT + x));
        dotList.remove(y * Matrix.CELL_X_COUNT + x);
    }

}
