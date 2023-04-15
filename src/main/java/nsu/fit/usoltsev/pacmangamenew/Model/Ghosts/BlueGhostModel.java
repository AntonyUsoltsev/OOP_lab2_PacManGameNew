package nsu.fit.usoltsev.pacmangamenew.Model.Ghosts;

import javafx.scene.layout.AnchorPane;
import nsu.fit.usoltsev.pacmangamenew.View.Ghosts.BlueGhostView;

public class BlueGhostModel extends GhostModel {

    public BlueGhostModel(AnchorPane root){
        ghostView = new BlueGhostView(root);
        xPosition = 24;
        yPosition = 24;
        xVelocity = 0;
        yVelocity = 0;
        nextDirection = "RIGHT";
    }
}
