package nsu.fit.usoltsev.pacmangamenew;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import nsu.fit.usoltsev.pacmangamenew.Control.PacManController;
import nsu.fit.usoltsev.pacmangamenew.Model.DotModel;
import nsu.fit.usoltsev.pacmangamenew.Model.FieldModel;
import nsu.fit.usoltsev.pacmangamenew.Model.Matrix;
import nsu.fit.usoltsev.pacmangamenew.View.WindowView;

import java.io.IOException;
import java.util.Objects;

public class Main extends javafx.application.Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("menu.fxml")));
        Scene scene = new Scene(root, Matrix.CELL_SIZE * Matrix.CELL_X_COUNT, Matrix.CELL_SIZE * Matrix.CELL_Y_COUNT);
        stage.setScene(scene);
        Button startBtn = (Button) root.lookup("#startButton");
        startBtn.setOnAction(event -> {
            root.getChildren().clear();
            WindowView.setWindowOptions(stage, scene);
            startBtn.setVisible(false);
            FieldModel.viewField(root);
            DotModel.setDots(root);
            PacManController pacManController = new PacManController(root);
            pacManController.control(scene);
        });
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        }
    }