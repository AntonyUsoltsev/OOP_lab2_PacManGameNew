package nsu.fit.usoltsev.pacmangamenew.Model.Ghosts;

import javafx.animation.AnimationTimer;
import nsu.fit.usoltsev.pacmangamenew.Model.Matrix;
import nsu.fit.usoltsev.pacmangamenew.View.Ghosts.GhostView;

import java.util.Random;

public class GhostModel {
    protected GhostView ghostView;

    public AnimationTimer getTimer() {
        return timer;
    }

    protected AnimationTimer timer;
    protected int xVelocity;
    protected int yVelocity;
    protected int xPosition;

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    protected int yPosition;
    protected String nextDirection;
    protected final String[] directionArr = {"RIGHT", "LEFT", "UP", "DOWN"};

//    public GhostModel(Group root) {
//        ghostView = new BlueGhostView(root);
//        xPosition = 24;
//        yPosition = 24;
//        xVelocity = 0;
//        yVelocity = 0;
//        nextDirection = "RIGHT";
//    }

    void setChanges(int position,int xVelocityChange, int yVelocityChange) {
        if (position % Matrix.CELL_SIZE == 0) {
            xVelocity = xVelocityChange;
            yVelocity = yVelocityChange;
        }
    }

    public void ghostMovement() {

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                switch (nextDirection) {
                    case ("RIGHT") -> {
                        setChanges(yPosition,1,0);
                        // System.out.println(yPosition+" " +xPosition);
                        if (xPosition / Matrix.CELL_SIZE + 1 >= Matrix.CELL_X_COUNT) {
                            if (xPosition % Matrix.CELL_SIZE > Matrix.CELL_SIZE / 2) {
                                xPosition = -Matrix.CELL_X_COUNT / 2;
                            }
                        } else if (yPosition % Matrix.CELL_SIZE == 0 && xPosition % Matrix.CELL_SIZE == 0) {
                            if (Matrix.matrix[xPosition / Matrix.CELL_SIZE + 1][yPosition / Matrix.CELL_SIZE] == 1) {
                                xVelocity = 0;
                                Random random = new Random();
                                int randomNumber = random.nextInt(4);
                                nextDirection = directionArr[randomNumber];
                            }

                        }
                    }
                    case ("LEFT") -> {
                        setChanges(yPosition,-1,0);
                        if (xPosition / Matrix.CELL_SIZE <= 0) {
                            // System.out.println(xPosition);
                            if (xPosition % Matrix.CELL_SIZE <= -Matrix.CELL_SIZE / 2) {
                                //System.out.println(xPosition % Matrix.CELL_SIZE);
                                xPosition = Matrix.CELL_X_COUNT * Matrix.CELL_SIZE + Matrix.CELL_X_COUNT / 2;
                                System.out.println(xPosition);
                            }
                        } else if (yPosition % Matrix.CELL_SIZE == 0 && xPosition % Matrix.CELL_SIZE == 0) {
                            if (Matrix.matrix[xPosition / Matrix.CELL_SIZE - 1][yPosition / Matrix.CELL_SIZE] == 1) {
                                xVelocity = 0;
                                Random random = new Random();
                                int randomNumber = random.nextInt(4);
                                nextDirection = directionArr[randomNumber];
                            } else if (xPosition / Matrix.CELL_SIZE >= Matrix.CELL_X_COUNT) {
                                System.out.println("HI");
                            }
                        }


                    }
                    case ("UP") -> {
                        setChanges(xPosition,0,-1);
                        if (xPosition % Matrix.CELL_SIZE == 0 && yPosition % Matrix.CELL_SIZE == 0) {
                            if (Matrix.matrix[xPosition / Matrix.CELL_SIZE][yPosition / Matrix.CELL_SIZE - 1] == 1) {
                                yVelocity = 0;
                                Random random = new Random();
                                int randomNumber = random.nextInt(4);
                                nextDirection = directionArr[randomNumber];
                            }

                        }
                    }
                    case ("DOWN") -> {
                        setChanges(xPosition,0,1);
                        if (xPosition % Matrix.CELL_SIZE == 0 && yPosition % Matrix.CELL_SIZE == 0) {
                            if (Matrix.matrix[xPosition / Matrix.CELL_SIZE][yPosition / Matrix.CELL_SIZE + 1] == 1) {
                                yVelocity = 0;
                                Random random = new Random();
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
