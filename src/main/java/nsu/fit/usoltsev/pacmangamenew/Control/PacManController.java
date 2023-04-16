package nsu.fit.usoltsev.pacmangamenew.Control;

import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import nsu.fit.usoltsev.pacmangamenew.Model.DotModel;
import nsu.fit.usoltsev.pacmangamenew.Model.FieldModel;
import nsu.fit.usoltsev.pacmangamenew.Model.Matrix;
import nsu.fit.usoltsev.pacmangamenew.Model.PacManModel;
import nsu.fit.usoltsev.pacmangamenew.View.WindowView;

public class PacManController {

    private static PacManModel pacManModel;

    public PacManController(AnchorPane root) {

    }

    public static Stage stage;
    public static Scene scene;
    public static AnchorPane root;



    public static void newGame() {
        root.getChildren().clear();
        WindowView.setWindowOptions(stage, scene);
        FieldModel.viewField(root);
        DotModel.clearDots();
        DotModel.setDots(root);
        pacManModel = new PacManModel(0, 0, Matrix.CELL_SIZE * Matrix.CELL_X_COUNT / 2, Matrix.CELL_SIZE * (Matrix.CELL_Y_COUNT / 2 + 1), "RIGHT", root);
        //PacManController pacManController = new PacManController(root);
        PacManController.control(scene);
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
