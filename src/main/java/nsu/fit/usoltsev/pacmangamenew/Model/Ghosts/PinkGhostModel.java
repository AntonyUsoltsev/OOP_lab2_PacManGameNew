package nsu.fit.usoltsev.pacmangamenew.Model.Ghosts;

import javafx.scene.Group;
import nsu.fit.usoltsev.pacmangamenew.View.Ghosts.PinkGhostView;

public class PinkGhostModel extends GhostModel {

    public PinkGhostModel(Group root){
        ghostView = new PinkGhostView(root);
        xPosition = 624;
        yPosition = 720;
        xVelocity = 0;
        yVelocity = 0;
        nextDirection = "LEFT";
    }
}
