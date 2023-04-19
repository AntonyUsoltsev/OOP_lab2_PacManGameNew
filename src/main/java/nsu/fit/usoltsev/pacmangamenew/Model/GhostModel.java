package nsu.fit.usoltsev.pacmangamenew.Model;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.AnchorPane;
import nsu.fit.usoltsev.pacmangamenew.View.GhostView;

import java.util.Random;

public class GhostModel {
    private final GhostView ghostView;
    private AnimationTimer timer;
    private final Random random = new Random();
    private int xVelocity, yVelocity;
    private int xPosition, yPosition;
    private String nextDirection;
    private final String[] directionArr = {"RIGHT", "LEFT", "UP", "DOWN"};

    public AnimationTimer getTimer() {
        return timer;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public GhostModel(AnchorPane root, int xPosition, int yPosition, String nextDirection, String picturePath) {
        this.ghostView = new GhostView(root, picturePath);
        this.xVelocity = 0;
        this.yVelocity = 0;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.nextDirection = nextDirection;
    }

    private void move(int newXVel, int newYVel, int xOffset, int yOffset, int xFlag) {
        if (yPosition % Matrix.CELL_SIZE == 0 && xPosition % Matrix.CELL_SIZE == 0) {
            xVelocity = newXVel;
            yVelocity = newYVel;
            if (Matrix.matrix[xPosition / Matrix.CELL_SIZE + xOffset][yPosition / Matrix.CELL_SIZE + yOffset] == Matrix.BORDER) {
                switch (xFlag) {
                    case 1 -> xVelocity = 0;
                    case 0 -> yVelocity = 0;
                }
                int randomNumber = random.nextInt(4);
                nextDirection = directionArr[randomNumber];
            }
        }
    }

    public void ghostMovement() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                switch (nextDirection) {
                    case ("RIGHT") -> move(1, 0, 1, 0, 1);
                    case ("LEFT") -> move(-1, 0, -1, 0, 1);
                    case ("UP") -> move(0, -1, 0, -1, 0);
                    case ("DOWN") -> move(0, 1, 0, 1, 0);
                }
                xPosition += xVelocity;
                yPosition += yVelocity;
                ghostView.viewGhost(xPosition, yPosition);
            }
        };

        timer.start();
    }
}
