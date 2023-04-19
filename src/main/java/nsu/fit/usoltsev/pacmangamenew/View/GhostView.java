package nsu.fit.usoltsev.pacmangamenew.View;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import nsu.fit.usoltsev.pacmangamenew.Model.Matrix;

import java.io.File;

public class GhostView {
    private final ImageView Ghost;

    public GhostView(AnchorPane root, String picturePath) {
        Image GhostImage = new Image(picturePath);
        Ghost = new ImageView(GhostImage);
        Ghost.setFitWidth(Matrix.CELL_SIZE);
        Ghost.setFitHeight(Matrix.CELL_SIZE);
        root.getChildren().add(Ghost);
    }

    public void viewGhost(int xPosition, int yPosition) {
        Ghost.setX(xPosition);
        Ghost.setY(yPosition);
    }
}
