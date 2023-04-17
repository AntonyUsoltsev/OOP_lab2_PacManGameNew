package nsu.fit.usoltsev.pacmangamenew.Model;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;

import nsu.fit.usoltsev.pacmangamenew.Model.Ghosts.*;
import nsu.fit.usoltsev.pacmangamenew.View.PacManView;


public class PacManModel {
    private int xVelocity, yVelocity, xPosition, yPosition;
    private String direction;
    private int score, health;
    private int xVelocityChange, yVelocityChange;
    private String keyPressed;
    private final PacManView pacManView;
    private final BlueGhostModel blueGhostModel;
    private final YellowGhostModel yellowGhostModel;
    private final RedGhostModel redGhostModel;
    private final PinkGhostModel pinkGhostModel;

    public void setxVelocityChange(int xVelocityChange) {
        this.xVelocityChange = xVelocityChange;
    }

    public void setyVelocityChange(int yVelocityChange) {
        this.yVelocityChange = yVelocityChange;
    }

    public void setKeyPressed(String keyPressed) {
        this.keyPressed = keyPressed;
    }

    public PacManModel(int xVelocity, int yVelocity, int xPosition, int yPosition, String direction, AnchorPane root) {
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.direction = direction;

        this.xVelocityChange = 0;
        this.yVelocityChange = 0;
        this.keyPressed = "RIGHT";

        this.score = 2000;
        this.health = 3;

        pacManView = new PacManView(root, health);

        blueGhostModel = new BlueGhostModel(root);
        blueGhostModel.ghostMovement();

        yellowGhostModel = new YellowGhostModel(root);
        yellowGhostModel.ghostMovement();

        redGhostModel = new RedGhostModel(root);
        redGhostModel.ghostMovement();

        pinkGhostModel = new PinkGhostModel(root);
        pinkGhostModel.ghostMovement();
    }

    private void setChanges(int position) {
        if (position % Matrix.CELL_SIZE == 0) {
            xVelocity = xVelocityChange;
            yVelocity = yVelocityChange;
            direction = keyPressed;
        }
    }

    private boolean ghostBump(GhostModel ghostModel) {
        return (xPosition - 1 <= ghostModel.getxPosition() && xPosition + 1 >= ghostModel.getxPosition()
                && yPosition - 1 <= ghostModel.getyPosition() && yPosition + 1 >= ghostModel.getyPosition());
    }

    private void eatDot(){
        if (Matrix.matrix[xPosition / Matrix.CELL_SIZE][yPosition / Matrix.CELL_SIZE] == Matrix.DOT) {
            DotModel.removeDot(xPosition / Matrix.CELL_SIZE, yPosition / Matrix.CELL_SIZE);
            score += Matrix.DOT_SCORE;
        }
    }

    public void movement() {

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                if (ghostBump(blueGhostModel) || ghostBump(redGhostModel) ||
                        ghostBump(pinkGhostModel) || ghostBump(yellowGhostModel)) {
                    keyPressed = "GHOST_BUMP";
                    health--;
                }


                switch (keyPressed) {
                    case ("RIGHT") -> {
                        setChanges(yPosition);
                        if (xPosition / Matrix.CELL_SIZE + 1 >= Matrix.CELL_X_COUNT) {
                            if (xPosition % Matrix.CELL_SIZE > Matrix.CELL_SIZE / 2) {
                                xPosition = -Matrix.CELL_X_COUNT / 2;
                            }
                        } else if (yPosition % Matrix.CELL_SIZE == 0 && xPosition % Matrix.CELL_SIZE == 0) {
                            if (Matrix.matrix[xPosition / Matrix.CELL_SIZE + 1][yPosition / Matrix.CELL_SIZE] == 1) {
                                xVelocity = 0;
                            }
                            eatDot();

                        }
                    }
                    case ("LEFT") -> {
                        setChanges(yPosition);
                        if (xPosition / Matrix.CELL_SIZE <= 0) {
                            // System.out.println(xPosition);
                            if (xPosition % Matrix.CELL_SIZE <= -Matrix.CELL_SIZE / 2) {
                                //System.out.println(xPosition % Matrix.CELL_SIZE);
                                xPosition = Matrix.CELL_X_COUNT * Matrix.CELL_SIZE + Matrix.CELL_X_COUNT / 2;
                                //  System.out.println(xPosition);
                            }
                        } else if (yPosition % Matrix.CELL_SIZE == 0 && xPosition % Matrix.CELL_SIZE == 0) {
                            if (Matrix.matrix[xPosition / Matrix.CELL_SIZE - 1][yPosition / Matrix.CELL_SIZE] == 1) {
                                xVelocity = 0;
                            } else if (xPosition / Matrix.CELL_SIZE >= Matrix.CELL_X_COUNT) {
                                System.out.println("HI");
                            } else if (Matrix.matrix[xPosition / Matrix.CELL_SIZE][yPosition / Matrix.CELL_SIZE] == 2) {

                                DotModel.removeDot(xPosition / Matrix.CELL_SIZE, yPosition / Matrix.CELL_SIZE);//????
                                score += 10;
                            }
                        }
                        //TODO: fix dots
                        //TODO: add method

                    }
                    case ("UP") -> {
                        setChanges(xPosition);
                        if (xPosition % Matrix.CELL_SIZE == 0 && yPosition % Matrix.CELL_SIZE == 0) {
                            if (Matrix.matrix[xPosition / Matrix.CELL_SIZE][yPosition / Matrix.CELL_SIZE - 1] == 1) {
                                yVelocity = 0;
                            }
                            eatDot();
                        }
                    }
                    case ("DOWN") -> {
                        setChanges(xPosition);
                        if (xPosition % Matrix.CELL_SIZE == 0 && yPosition % Matrix.CELL_SIZE == 0) {
                            if (Matrix.matrix[xPosition / Matrix.CELL_SIZE][yPosition / Matrix.CELL_SIZE + 1] == 1) {
                                yVelocity = 0;
                            }
                            eatDot();

                        }
                    }
                    case ("GHOST_BUMP") -> {
                        xVelocity = 0;
                        yVelocity = 0;
                        if (health != 0) {
                            xPosition = Matrix.CELL_SIZE * Matrix.CELL_X_COUNT / 2;
                            yPosition = Matrix.CELL_SIZE * (Matrix.CELL_Y_COUNT / 2 + 1);
                        }
                        if (health == 0) {
                            redGhostModel.getTimer().stop();
                            pinkGhostModel.getTimer().stop();
                            yellowGhostModel.getTimer().stop();
                            blueGhostModel.getTimer().stop();
                            super.stop();
                        }

                    }
                }
                if (score >= Matrix.MAX_SCORE) {
                    xVelocity = 0;
                    yVelocity = 0;
                    redGhostModel.getTimer().stop();
                    pinkGhostModel.getTimer().stop();
                    yellowGhostModel.getTimer().stop();
                    blueGhostModel.getTimer().stop();
                    super.stop();
                }

                xPosition += xVelocity;
                yPosition += yVelocity;
                pacManView.viewPacMan(xPosition, yPosition, direction, score, health);
            }
        };

        timer.start();

    }
}
