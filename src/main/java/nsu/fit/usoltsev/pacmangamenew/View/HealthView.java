package nsu.fit.usoltsev.pacmangamenew.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import nsu.fit.usoltsev.pacmangamenew.Control.PacManController;
import nsu.fit.usoltsev.pacmangamenew.Model.Matrix;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;

public class HealthView {
    private final AnchorPane root;
    private final LinkedList<ImageView> hearts = new LinkedList<>();

    public HealthView(AnchorPane root, int health) {
        this.root = root;
        Image heartImage = new Image("pictures/Heart.png");
        for (int i = 0; i < health; i++) {
            ImageView heart = new ImageView(heartImage);
            heart.setFitWidth(Matrix.CELL_SIZE);
            heart.setFitHeight(Matrix.CELL_SIZE);
            heart.setX(24 * (i + 7));
            heart.setY(0);
            hearts.add(heart);
            root.getChildren().add(hearts.get(i));
        }
    }

    public void drawHealth(int health) {
        if (health < hearts.size()) {
            root.getChildren().remove(hearts.getLast());
            hearts.removeLast();
            if (hearts.size() == 0) {
                try {
                    root.getChildren().add(FXMLLoader.load(Objects.requireNonNull(HealthView.class.getResource("lose.fxml"))));

                    Button startBtn = (Button) root.lookup("#startButton");
                    startBtn.setOnAction(event -> PacManController.newGame());

                    Button endBtn = (Button) root.lookup("#exitButton");
                    endBtn.setOnAction(event -> System.exit(0));

                    Button menuButton = (Button) root.lookup("#menuButton");
                    menuButton.setOnAction(event -> PacManController.newMenu());

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
