package nsu.fit.usoltsev.pacmangamenew.View.Ghosts;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class RedGhostView  extends GhostView {
    public RedGhostView(Group root) {
        File redGhostFile = new File("./src/main/resources/pictures/GhostPictures/RedGhost.png");
        GhostImage = new Image(redGhostFile.toURI().toString());
        Ghost = new ImageView();
        root.getChildren().add(Ghost);
    }
}
