package nsu.fit.usoltsev.pacmangamenew;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import nsu.fit.usoltsev.pacmangamenew.Control.PacManController;
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

        WindowView.setWindowOptions(stage);
        PacManController pacManController = new PacManController(stage);
        pacManController.newMenu();
        stage.setScene(pacManController.scene);
        stage.setResizable(false);
        stage.show();
        }
    }