package nsu.fit.usoltsev.pacmangamenew.Model;

import javafx.scene.Group;
import nsu.fit.usoltsev.pacmangamenew.View.FieldView;

public class FieldModel {
    static FieldView fieldView;

    static {
        fieldView = new FieldView();
        Matrix.setMatrix();
    }

    public static void viewField(Group root) {
        fieldView.drawBorders(root, Matrix.matrix);
    }
}
