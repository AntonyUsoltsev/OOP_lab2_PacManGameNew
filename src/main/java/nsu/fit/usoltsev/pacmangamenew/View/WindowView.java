package nsu.fit.usoltsev.pacmangamenew.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import nsu.fit.usoltsev.pacmangamenew.Main;
import nsu.fit.usoltsev.pacmangamenew.Model.*;

import java.io.File;


public class WindowView {
    public static void setWindowOptions(Stage stage, Scene scene) {
        scene.setFill(Color.rgb(2, 0, 9));
        File iconFile = new File("./src/main/resources/pictures/PacManPictures/PacmanRight.png");
        Image icon = new Image(iconFile.toURI().toString());
        stage.getIcons().add(icon);
        stage.setTitle("Pac Man");
    }
}
