package nsu.fit.usoltsev.pacmangamenew.View;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import nsu.fit.usoltsev.pacmangamenew.Model.*;

import java.io.File;

public class PacManView {
    static Image imageRight, imageLeft, imageUp, imageDown;
    static Image imageRightClosed, imageLeftClosed, imageUpClosed, imageDownClosed;
    ImageView pacMan;
    boolean isClosed = true;
    int i = 0;

    public PacManView(Group root) {

        File pacmanRight = new File("./src/main/resources/pictures/PacManPictures/PacmanRight.png");
        File pacmanLeft = new File("./src/main/resources/pictures/PacManPictures/PacmanLeft.png");
        File pacmanUp = new File("./src/main/resources/pictures/PacManPictures/PacmanUp.png");
        File pacmanDown = new File("./src/main/resources/pictures/PacManPictures/PacmanDown.png");

        imageRight = new Image(pacmanRight.toURI().toString());
        imageLeft = new Image(pacmanLeft.toURI().toString());
        imageUp = new Image(pacmanUp.toURI().toString());
        imageDown = new Image(pacmanDown.toURI().toString());

        File pacmanRightClosed = new File("./src/main/resources/pictures/PacManPictures/PacmanRightClosed.png");
        File pacmanLeftClosed = new File("./src/main/resources/pictures/PacManPictures/PacmanLeftClosed.png");
        File pacmanUpClosed = new File("./src/main/resources/pictures/PacManPictures/PacmanUpClosed.png");
        File pacmanDownClosed = new File("./src/main/resources/pictures/PacManPictures/PacmanDownClosed.png");

        imageRightClosed = new Image(pacmanRightClosed.toURI().toString());
        imageLeftClosed = new Image(pacmanLeftClosed.toURI().toString());
        imageUpClosed = new Image(pacmanUpClosed.toURI().toString());
        imageDownClosed = new Image(pacmanDownClosed.toURI().toString());

        pacMan = new ImageView();
        root.getChildren().add(pacMan);
        HealthScoreView.setRoot(root);
        HealthScoreView.setScore();
        HealthScoreView.setHealth();
    }

    void setImage(Image image, Image imageClosed) {
        if (i < 10) {
            pacMan.setImage(image);
            i++;
        } else if (i > 20) {
            i = 0;
        } else {
            pacMan.setImage(imageClosed);
            isClosed = false;
            i++;
        }
    }

    public void  viewPacMan(int xPosition, int yPosition, String direction, int score, int health) {
        switch (direction) {
            case "RIGHT" -> {
                setImage(imageRight, imageRightClosed);
            }
            case "LEFT" -> {
                setImage(imageLeft, imageLeftClosed);
            }
            case "UP" -> {
                setImage(imageUp, imageUpClosed);
            }
            case "DOWN" -> {
                setImage(imageDown, imageDownClosed);
            }
        }
        pacMan.setFitWidth(Matrix.CELL_SIZE);
        pacMan.setFitHeight(Matrix.CELL_SIZE);
        pacMan.setX(xPosition);
        pacMan.setY(yPosition);
        HealthScoreView.drawHealth(health);
        HealthScoreView.drawScore(score);
    }
}
