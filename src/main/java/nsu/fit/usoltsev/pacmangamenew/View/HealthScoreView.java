package nsu.fit.usoltsev.pacmangamenew.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import nsu.fit.usoltsev.pacmangamenew.Control.PacManController;
import nsu.fit.usoltsev.pacmangamenew.Model.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;

public class HealthScoreView {
    private final AnchorPane root;
    private Text scoreText;
    private Text time;
    private final LinkedList<ImageView> hearts = new LinkedList<>();

    public HealthScoreView(AnchorPane root) {
        this.root = root;
    }

    public void setScore() {
        scoreText = new Text(40, 20, "");
        scoreText.setFill(Color.YELLOW);
        scoreText.setFont(new Font(20));
        root.getChildren().add(scoreText);
    }

    public void setHealth(int health) {
        Image heartImage = new Image("pictures/Heart.png");
        for (int i = 0; i < health; i++) {
            ImageView heart = new ImageView(heartImage);
            heart.setFitWidth(Matrix.CELL_SIZE);
            heart.setFitHeight(Matrix.CELL_SIZE);
            heart.setX(24 * (i + 6));
            heart.setY(0);
            hearts.add(heart);
            root.getChildren().add(hearts.get(i));
        }
    }

    public void setTime() {
        time = new Text(500, 20, "");
        time.setFill(Color.YELLOW);
        time.setFont(new Font(20));
        root.getChildren().add(time);
    }

    public void drawScore(int score) {
        scoreText.setText("Score: " + (score));
        if (score >= Matrix.MAX_SCORE) {
            try {
                root.getChildren().add(FXMLLoader.load(Objects.requireNonNull(HealthScoreView.class.getResource("win.fxml"))));
                System.out.println("win");

                Button startBtn = (Button) root.lookup("#startButton");
                startBtn.setOnAction(event -> PacManController.newGame());

                Button endBtn = (Button) root.lookup("#endButton");
                endBtn.setOnAction(event -> System.exit(0));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void drawHealth(int health) {
        if (health < hearts.size()) {
            root.getChildren().remove(hearts.getLast());
            hearts.removeLast();
            if (hearts.size() == 0) {
                try {
                    root.getChildren().add(FXMLLoader.load(Objects.requireNonNull(HealthScoreView.class.getResource("lose.fxml"))));

                    Button startBtn = (Button) root.lookup("#startButton");
                    startBtn.setOnAction(event -> PacManController.newGame());

                    Button endBtn = (Button) root.lookup("#endButton");
                    endBtn.setOnAction(event -> System.exit(0));

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void drawTime(long curTime) {
        time.setText("Time: " + (curTime / 1_000_000_000) + " sec");
    }

}
