package nsu.fit.usoltsev.pacmangamenew.View.Ghosts;

import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class PinkGhostView extends GhostView {
    public PinkGhostView(AnchorPane root) {
        File pinkGhostFile = new File("./src/main/resources/pictures/GhostPictures/PinkGhost.png");
        GhostImage = new Image(pinkGhostFile.toURI().toString());
        Ghost = new ImageView();
        root.getChildren().add(Ghost);
    }

}
