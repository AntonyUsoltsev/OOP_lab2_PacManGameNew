package nsu.fit.usoltsev.pacmangamenew.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import nsu.fit.usoltsev.pacmangamenew.Control.PacManController;
import nsu.fit.usoltsev.pacmangamenew.Model.Matrix;

import java.util.Objects;

public class ScoreView {
    private final AnchorPane root;
    private final Text scoreText;

    public ScoreView(AnchorPane root) {
        this.root = root;
        scoreText = new Text(40, 20, "");
        scoreText.setFill(Color.YELLOW);
        scoreText.setFont(new Font(20));
        root.getChildren().add(scoreText);
    }

    public void drawScore(int score) {
        scoreText.setText("Score: " + (score));
        if (score >= Matrix.MAX_SCORE) {
            try {
                root.getChildren().add(FXMLLoader.load(Objects.requireNonNull(HealthView.class.getResource("win.fxml"))));
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


}
