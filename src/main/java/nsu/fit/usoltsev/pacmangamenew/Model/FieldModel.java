package nsu.fit.usoltsev.pacmangamenew.Model;

import javafx.scene.layout.AnchorPane;
import nsu.fit.usoltsev.pacmangamenew.View.FieldView;

public class FieldModel {
    static FieldView fieldView;

    static {
        fieldView = new FieldView();
        Matrix.setMatrix();
    }

    public static void viewField(AnchorPane root) {
        fieldView.drawBorders(root, Matrix.matrix);
    }
}
