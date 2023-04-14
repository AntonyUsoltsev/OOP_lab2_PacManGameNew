package nsu.fit.usoltsev.pacmangamenew.Model.Ghosts;

import javafx.scene.Group;
import nsu.fit.usoltsev.pacmangamenew.View.Ghosts.RedGhostView;

public class RedGhostModel extends GhostModel {

    public RedGhostModel(Group root){
        ghostView = new RedGhostView(root);
        xPosition = 24;
        yPosition = 720;
        xVelocity = 0;
        yVelocity = 0;
        nextDirection = "RIGHT";
    }
}
