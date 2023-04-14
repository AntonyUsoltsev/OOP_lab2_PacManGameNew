package nsu.fit.usoltsev.pacmangamenew.Control;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import nsu.fit.usoltsev.pacmangamenew.Model.Matrix;
import nsu.fit.usoltsev.pacmangamenew.Model.PacManModel;

public class PacManController {

    static PacManModel pacManModel;

    public PacManController(Group root) {
        pacManModel = new PacManModel(0, 0, Matrix.CELL_SIZE * Matrix.CELL_X_COUNT / 2, Matrix.CELL_SIZE * (Matrix.CELL_Y_COUNT / 2 + 1), "RIGHT", root);
    }

    public static void control(Scene scene) {


        scene.setOnKeyPressed(event -> {


            if (event.getCode() == KeyCode.RIGHT) {
                pacManModel.setKeyPressed("RIGHT");
                pacManModel.setxVelocityChange(2);
                pacManModel.setyVelocityChange(0);
            } else if (event.getCode() == KeyCode.LEFT) {
                pacManModel.setKeyPressed("LEFT");
                pacManModel.setxVelocityChange(-2);
                pacManModel.setyVelocityChange(0);
            } else if (event.getCode() == KeyCode.UP) {
                pacManModel.setKeyPressed("UP");
                pacManModel.setxVelocityChange(0);
                pacManModel.setyVelocityChange(-2);
            } else if (event.getCode() == KeyCode.DOWN) {
                pacManModel.setKeyPressed("DOWN");
                pacManModel.setxVelocityChange(0);
                pacManModel.setyVelocityChange(2);
            } else if (event.getCode() == KeyCode.SPACE) {
                pacManModel.setxVelocityChange(0);
                pacManModel.setyVelocityChange(0);
            }
        });

        pacManModel.movement(scene);

    }

}
