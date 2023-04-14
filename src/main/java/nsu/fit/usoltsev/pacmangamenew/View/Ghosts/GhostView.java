package nsu.fit.usoltsev.pacmangamenew.View.Ghosts;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nsu.fit.usoltsev.pacmangamenew.Model.Matrix;

import java.io.File;

public class GhostView {
    protected Image GhostImage;
    protected ImageView Ghost;

//    public GhostView(Group root, File GhostFile) {
//        GhostImage = new Image(GhostFile.toURI().toString());
//        Ghost = new ImageView();
//        root.getChildren().add(Ghost);
//    }
    public void viewGhost(int xPosition, int yPosition) {
        Ghost.setImage(GhostImage);
        Ghost.setFitWidth(Matrix.CELL_SIZE);
        Ghost.setFitHeight(Matrix.CELL_SIZE);
        Ghost.setX(xPosition);
        Ghost.setY(yPosition);
    }
}
