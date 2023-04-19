package nsu.fit.usoltsev.pacmangamenew.View;

import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nsu.fit.usoltsev.pacmangamenew.Model.*;

public class PacManView {
    private static final Image
            imageRight = new Image("/pictures/PacManPictures/PacmanRight.png"),
            imageLeft = new Image("/pictures/PacManPictures/PacmanLeft.png"),
            imageUp = new Image("/pictures/PacManPictures/PacmanUp.png"),
            imageDown = new Image("/pictures/PacManPictures/PacmanDown.png"),
            imageRightClosed = new Image("/pictures/PacManPictures/PacmanRightClosed.png"),
            imageLeftClosed = new Image("/pictures/PacManPictures/PacmanLeftClosed.png"),
            imageUpClosed = new Image("/pictures/PacManPictures/PacmanUpClosed.png"),
            imageDownClosed = new Image("/pictures/PacManPictures/PacmanDownClosed.png");
    private final ImageView pacMan;
    private final HealthView healthView;
    private final ScoreView scoreView;
    private final TimeView timeView;

    private int i = 0;

    public PacManView(AnchorPane root, int health) {
        pacMan = new ImageView();
        root.getChildren().add(pacMan);

        healthView = new HealthView(root,health);
        scoreView = new ScoreView(root);
        timeView = new TimeView(root);
    }

    void setPacManImage(Image image, Image imageClosed) {
        if (i < 10) {
            pacMan.setImage(image);
            i++;
        } else if (i > 20) {
            i = 0;
        } else {
            pacMan.setImage(imageClosed);
            i++;
        }
    }

    public void viewPacMan(int xPosition, int yPosition, String direction, int score, int health, long curTime) {
        switch (direction) {
            case "RIGHT" -> setPacManImage(imageRight, imageRightClosed);
            case "LEFT" -> setPacManImage(imageLeft, imageLeftClosed);
            case "UP" -> setPacManImage(imageUp, imageUpClosed);
            case "DOWN" -> setPacManImage(imageDown, imageDownClosed);
        }
        pacMan.setFitWidth(Matrix.CELL_SIZE);
        pacMan.setFitHeight(Matrix.CELL_SIZE);
        pacMan.setX(xPosition);
        pacMan.setY(yPosition);
        scoreView.drawScore(score);
        healthView.drawHealth(health);
        timeView.drawTime(curTime);
    }
}
