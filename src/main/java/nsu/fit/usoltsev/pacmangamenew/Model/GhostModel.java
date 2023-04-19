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
        this.ghostView = new GhostView(root, picturePath);
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

    private void Move(int newXVel, int newYVel, int xOffset, int yOffset, int xFlag) {
        switch (xFlag) {
            case 1 -> setChanges(yPosition, newXVel, 0);
            case 0 -> setChanges(xPosition, 0, newYVel);
        }
       // setChanges(xFlag == 0 ? xPosition : yPosition, newXVel * xFlag, newYVel * ((xFlag + 1) % 2));

        if (yPosition % Matrix.CELL_SIZE == 0 && xPosition % Matrix.CELL_SIZE == 0) {
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

    private void xMove(int newXVel, int xOffset) {
        setChanges(yPosition, newXVel, 0);
        if (yPosition % Matrix.CELL_SIZE == 0 && xPosition % Matrix.CELL_SIZE == 0) {
            if (Matrix.matrix[xPosition / Matrix.CELL_SIZE + xOffset][yPosition / Matrix.CELL_SIZE] == Matrix.BORDER) {
                xVelocity = 0;
                int randomNumber = random.nextInt(4);
                nextDirection = directionArr[randomNumber];
            }
        }
    }

    private void yMove(int newYVel, int yOffset) {
        setChanges(xPosition, 0, newYVel);
        if (xPosition % Matrix.CELL_SIZE == 0 && yPosition % Matrix.CELL_SIZE == 0) {
            if (Matrix.matrix[xPosition / Matrix.CELL_SIZE][yPosition / Matrix.CELL_SIZE + yOffset] == Matrix.BORDER) {
                yVelocity = 0;
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
                    case ("RIGHT") -> Move(1, 0,1,0,1);
                    case ("LEFT") -> Move(-1, 0,-1,0,1);
                    case ("UP") -> Move(0,-1,0, -1,0);
                    case ("DOWN") -> Move(0,1,0, 1,0);
                }
                xPosition += xVelocity;
                yPosition += yVelocity;
                ghostView.viewGhost(xPosition, yPosition);
            }
        };

        timer.start();
    }
}
