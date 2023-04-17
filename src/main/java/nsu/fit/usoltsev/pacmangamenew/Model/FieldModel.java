package nsu.fit.usoltsev.pacmangamenew.Model;

import javafx.scene.layout.AnchorPane;
import nsu.fit.usoltsev.pacmangamenew.View.FieldView;

public class FieldModel {
    static FieldView fieldView;

    public static void viewField(AnchorPane root) {
        fieldView = new FieldView();
        fieldView.drawBorders(root, Matrix.matrix);
    }
}
