package nsu.fit.usoltsev.pacmangamenew.View;

import javafx.scene.image.Image;
import javafx.stage.Stage;

public class WindowView {
    public static void setWindowOptions(Stage stage) {
        Image icon = new Image("/pictures/PacManPictures/PacmanRight.png");
        stage.getIcons().add(icon);
        stage.setTitle("Pac Man");
    }
}
