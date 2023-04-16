package nsu.fit.usoltsev.pacmangamenew.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import nsu.fit.usoltsev.pacmangamenew.Control.PacManController;
import nsu.fit.usoltsev.pacmangamenew.Main;
import nsu.fit.usoltsev.pacmangamenew.Model.*;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;

public class HealthScoreView {
    static AnchorPane root;
    static private Text scoreText;
    static private final LinkedList<ImageView> hearts = new LinkedList<>();

    public static void setRoot(AnchorPane root) {
        HealthScoreView.root = root;
    }

    public static void setScore() {
        scoreText = new Text();
        scoreText.setX(20);
        scoreText.setY(20);
        scoreText.setFill(Color.YELLOW);
        scoreText.setFont(new Font(20));
        root.getChildren().add(scoreText);
    }

    public static void setHealth(int health) {
        File heartFile = new File("./src/main/resources/pictures/Heart.png");
        Image heartImage = new Image(heartFile.toURI().toString());
        for (int i = 0; i < health; i++) {
            ImageView heart = new ImageView(heartImage);
            heart.setFitWidth(Matrix.CELL_SIZE);
            heart.setFitHeight(Matrix.CELL_SIZE);
            heart.setX(24 * (i + 3));
            heart.setY(0);
            hearts.add(heart);
            root.getChildren().add(hearts.get(i));
        }
    }

    public static void drawHealth(int health) {
        if (health < hearts.size()) {
            root.getChildren().remove(hearts.getLast());
            hearts.removeLast();
            if (hearts.size() == 0) {
                try {
                    //  root.getChildren().clear();
                    root.getChildren().add(FXMLLoader.load(Objects.requireNonNull(HealthScoreView.class.getResource("lose.fxml"))));

                    Button startBtn = (Button) root.lookup("#startButton");
                    startBtn.setOnAction(event -> PacManController.newGame());

                    Button endBtn = (Button) root.lookup("#endButton");
                    endBtn.setOnAction(event -> System.exit(0));

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }

    public static void drawScore(int score) {
        scoreText.setText(Integer.toString(score));
        if (score == Matrix.MAX_SCORE) {
            try {
                Thread.sleep(1000);
                root.getChildren().clear();
                root.getChildren().add(FXMLLoader.load(Objects.requireNonNull(HealthScoreView.class.getResource("win.fxml"))));
                Button startBtn = (Button) root.lookup("#startButton");
                startBtn.setOnAction(event -> {
                    PacManController.newGame();
                });
                Button endBtn = (Button) root.lookup("#endButton");
                endBtn.setOnAction(event -> {
                    System.exit(0);
                });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
