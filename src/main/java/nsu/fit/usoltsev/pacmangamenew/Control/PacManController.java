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
        root.setBackground(new Background(new BackgroundFill(Color.rgb(2, 0, 9),new CornerRadii(0), Insets.EMPTY)));
        Matrix.setMatrix();
        FieldModel.viewField(root);
        DotModel.setDots(root);
        pacManModel = new PacManModel(0, 0, Matrix.CELL_SIZE * Matrix.CELL_X_COUNT / 2, Matrix.CELL_SIZE * (Matrix.CELL_Y_COUNT / 2 + 1), "RIGHT", root);
        control(scene);
    }

    public static void control(Scene scene) {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case RIGHT -> {
                    pacManModel.setKeyPressed("RIGHT");
                    pacManModel.setxVelocityChange(2);
                    pacManModel.setyVelocityChange(0);
                }
                case LEFT -> {
                    pacManModel.setKeyPressed("LEFT");
                    pacManModel.setxVelocityChange(-2);
                    pacManModel.setyVelocityChange(0);
                }
                case DOWN -> {
                    pacManModel.setKeyPressed("DOWN");
                    pacManModel.setxVelocityChange(0);
                    pacManModel.setyVelocityChange(2);
                }
                case UP -> {
                    pacManModel.setKeyPressed("UP");
                    pacManModel.setxVelocityChange(0);
                    pacManModel.setyVelocityChange(-2);
                }
                case SPACE -> {
                    pacManModel.setxVelocityChange(0);
                    pacManModel.setyVelocityChange(0);
                }
            }
        });

        pacManModel.movement();
    }
}
