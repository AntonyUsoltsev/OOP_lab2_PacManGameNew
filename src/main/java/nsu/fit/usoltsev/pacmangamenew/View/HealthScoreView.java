package nsu.fit.usoltsev.pacmangamenew.View;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import nsu.fit.usoltsev.pacmangamenew.Model.*;

import java.io.File;

public class HealthScoreView {
    static Group root;
    static Text scoreText;
    static Image heartImage;
    static ImageView heart1;
    static ImageView heart2;
    static ImageView heart3;

    public static void setRoot(Group root){
        HealthScoreView.root = root;
    }
    public static void setScore(){
        scoreText = new Text();
        scoreText.setX(20);
        scoreText.setY(20);
        scoreText.setFill(Color.YELLOW);
        scoreText.setFont(new Font(20));
        root.getChildren().add(scoreText);
    }
    private static void setHealthProperties(ImageView imageView,  int xPosition, int yPosition){
        imageView = new ImageView(heartImage);
        imageView.setFitWidth(Matrix.CELL_SIZE);
        imageView.setFitHeight(Matrix.CELL_SIZE);
        imageView.setX(xPosition);
        imageView.setY(yPosition);
        root.getChildren().add(imageView);
    }


    public void win(){

    }

    public static void setHealth(){
        File heartFile = new File("./src/main/resources/pictures/Heart.png");
        heartImage = new Image(heartFile.toURI().toString());

        heart1 = new ImageView(heartImage);
        heart1.setFitWidth(Matrix.CELL_SIZE);
        heart1.setFitHeight(Matrix.CELL_SIZE);
        heart1.setX(72);
        heart1.setY(0);
        root.getChildren().add(heart1);
        heart2 = new ImageView(heartImage);
        heart2.setFitWidth(Matrix.CELL_SIZE);
        heart2.setFitHeight(Matrix.CELL_SIZE);
        heart2.setX(96);
        heart2.setY(0);
        root.getChildren().add(heart2);
        heart3 = new ImageView(heartImage);
        heart3.setFitWidth(Matrix.CELL_SIZE);
        heart3.setFitHeight(Matrix.CELL_SIZE);
        heart3.setX(120);
        heart3.setY(0);
        root.getChildren().add(heart3);
//        setHealthProperties(heart1, 72,0);
//        setHealthProperties(heart2, 96,0);
//        setHealthProperties(heart3, 120,0);
    }
    public  static  void drawHealth(int health){
        switch (health){
            case(2)->{
                root.getChildren().remove(heart3);
            }
            case(1)->{
                root.getChildren().remove(heart2);
            }
            case(0)->{
                root.getChildren().remove(heart1);
                Text lose = new Text("YOU LOSE");
                lose.setFill(Color.WHITE);
                lose.setX(160);
                lose.setY(370);
                lose.setStroke(Color.RED);
                lose.setStrokeWidth(5);
                lose.setFont(new Font(70));
                root.getChildren().add(lose);
            }
        }
    }

    public static void drawScore(int score) {
        scoreText.setText(Integer.toString(score));
        if(score == Matrix.MAX_SCORE){
            Text win = new Text("YOU WIN");
            win.setFill(Color.WHITE);
            win.setX(200);
            win.setY(370);
            win.setStroke(Color.YELLOW);
            win.setStrokeWidth(5);
            win.setFont(new Font(70));
            root.getChildren().add(win);
        }
    }
}
