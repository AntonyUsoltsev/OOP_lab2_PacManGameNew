package nsu.fit.usoltsev.pacmangamenew.Control;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import nsu.fit.usoltsev.pacmangamenew.Main;
import nsu.fit.usoltsev.pacmangamenew.Model.DotModel;
import nsu.fit.usoltsev.pacmangamenew.Model.FieldModel;
import nsu.fit.usoltsev.pacmangamenew.Model.Matrix;
import nsu.fit.usoltsev.pacmangamenew.Model.PacManModel;

import java.io.IOException;
import java.util.Objects;

public class PacManController {
    private PacManModel pacManModel;
    public Scene scene;
    public AnchorPane root;
    public Stage stage;

    public PacManController(){}
    public PacManController(Stage stage){
        this.stage = stage;
    }
    public void newMenu() {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(PacManController.class.getResource("menu.fxml")));
            scene = new Scene(root, Matrix.CELL_SIZE * Matrix.CELL_X_COUNT, Matrix.CELL_SIZE * Matrix.CELL_Y_COUNT);
            Button startBtn = (Button) root.lookup("#startButton");
            Button endBtn = (Button) root.lookup("#exitButton");

            startBtn.setOnAction(event -> newGame());

            endBtn.setOnAction(event -> System.exit(0));
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void newGame() {
        root.getChildren().clear();
        root.setBackground(new Background(new BackgroundFill(Color.rgb(2, 0, 10), new CornerRadii(0), Insets.EMPTY)));
        Matrix.setMatrix();
        FieldModel.viewField(root);
        DotModel.setDots(root);
        pacManModel = new PacManModel(0, 0, Matrix.X_SPAWN, Matrix.Y_SPAWN, "RIGHT", root);
        System.out.println("Game started");
        control(scene);
    }

    private void action(String direction, int xVel, int yVel) {
        pacManModel.setKeyPressed(direction);
        pacManModel.setxVelocityChange(xVel);
        pacManModel.setyVelocityChange(yVel);
    }

    public void control(Scene scene) {
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
