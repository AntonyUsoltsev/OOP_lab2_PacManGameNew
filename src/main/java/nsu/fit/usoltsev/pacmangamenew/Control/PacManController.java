package nsu.fit.usoltsev.pacmangamenew.Control;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import nsu.fit.usoltsev.pacmangamenew.Model.DotModel;
import nsu.fit.usoltsev.pacmangamenew.Model.FieldModel;
import nsu.fit.usoltsev.pacmangamenew.Model.Matrix;
import nsu.fit.usoltsev.pacmangamenew.Model.PacManModel;

public class PacManController {
    private static PacManModel pacManModel;
    public static Scene scene;
    public static AnchorPane root;

    public static void newGame() {
        root.getChildren().clear();
        root.setBackground(new Background(new BackgroundFill(Color.rgb(2, 0, 10), new CornerRadii(0), Insets.EMPTY)));
        Matrix.setMatrix();
        FieldModel.viewField(root);
        DotModel.setDots(root);
        pacManModel = new PacManModel(0, 0, Matrix.X_SPAWN, Matrix.Y_SPAWN, "RIGHT", root);
        control(scene);
    }

    private static void action(String direction, int xVel, int yVel) {
        pacManModel.setKeyPressed(direction);
        pacManModel.setxVelocityChange(xVel);
        pacManModel.setyVelocityChange(yVel);
    }

    public static void control(Scene scene) {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case RIGHT -> action("RIGHT", 2, 0);
                case LEFT -> action("LEFT", -2, 0);
                case DOWN -> action("DOWN", 0, 2);
                case UP -> action("UP", 0, -2);
                case SPACE -> {
                    pacManModel.setxVelocityChange(0);
                    pacManModel.setyVelocityChange(0);
                }
            }
        });

        pacManModel.movement();
    }
}
