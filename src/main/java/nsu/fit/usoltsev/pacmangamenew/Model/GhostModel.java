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

    public GhostModel(AnchorPane root, int xPosition, int yPosition, String nextDirection, String picturePath) {
        this.ghostView = new GhostView(root,picturePath);
        this.xVelocity = 0;
        this.yVelocity = 0;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.nextDirection = nextDirection;
    }


    public AnimationTimer getTimer() {
        return timer;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    void setChanges(int position, int xVelocityChange, int yVelocityChange) {
        if (position % Matrix.CELL_SIZE == 0) {
            xVelocity = xVelocityChange;
            yVelocity = yVelocityChange;
        }
    }

    public void ghostMovement() {

        //TODO: ghost fabric

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                switch (nextDirection) {
                    case ("RIGHT") -> {
                        setChanges(yPosition, 1, 0);
                        if (yPosition % Matrix.CELL_SIZE == 0 && xPosition % Matrix.CELL_SIZE == 0) {
                            if (Matrix.matrix[xPosition / Matrix.CELL_SIZE + 1][yPosition / Matrix.CELL_SIZE] == 1) {
                                xVelocity = 0;
                                int randomNumber = random.nextInt(4);
                                nextDirection = directionArr[randomNumber];
                            }

                        }
                    }
                    case ("LEFT") -> {
                        setChanges(yPosition, -1, 0);
                        if (yPosition % Matrix.CELL_SIZE == 0 && xPosition % Matrix.CELL_SIZE == 0) {
                            if (Matrix.matrix[xPosition / Matrix.CELL_SIZE - 1][yPosition / Matrix.CELL_SIZE] == 1) {
                                xVelocity = 0;
                                int randomNumber = random.nextInt(4);
                                nextDirection = directionArr[randomNumber];
                            }
                        }
                    }
                    case ("UP") -> {
                        setChanges(xPosition, 0, -1);
                        if (xPosition % Matrix.CELL_SIZE == 0 && yPosition % Matrix.CELL_SIZE == 0) {
                            if (Matrix.matrix[xPosition / Matrix.CELL_SIZE][yPosition / Matrix.CELL_SIZE - 1] == 1) {
                                yVelocity = 0;
                                int randomNumber = random.nextInt(4);
                                nextDirection = directionArr[randomNumber];
                            }

                        }
                    }
                    case ("DOWN") -> {
                        setChanges(xPosition, 0, 1);
                        if (xPosition % Matrix.CELL_SIZE == 0 && yPosition % Matrix.CELL_SIZE == 0) {
                            if (Matrix.matrix[xPosition / Matrix.CELL_SIZE][yPosition / Matrix.CELL_SIZE + 1] == 1) {
                                yVelocity = 0;
                                int randomNumber = random.nextInt(4);
                                nextDirection = directionArr[randomNumber];
                            }
                        }
                    }
                }

                xPosition += xVelocity;
                yPosition += yVelocity;
                ghostView.viewGhost(xPosition, yPosition);
            }
        };

        timer.start();
    }
}
