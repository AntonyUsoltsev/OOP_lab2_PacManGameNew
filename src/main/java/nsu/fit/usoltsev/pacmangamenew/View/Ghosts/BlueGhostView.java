package nsu.fit.usoltsev.pacmangamenew.View.Ghosts;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class BlueGhostView extends GhostView {
    public BlueGhostView(Group root) {
        File blueGhostFile = new File("./src/main/resources/pictures/GhostPictures/BlueGhost.png");
        GhostImage = new Image(blueGhostFile.toURI().toString());
        Ghost = new ImageView();
        root.getChildren().add(Ghost);
    }
}
