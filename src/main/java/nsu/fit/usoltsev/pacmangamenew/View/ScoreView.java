package nsu.fit.usoltsev.pacmangamenew.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import nsu.fit.usoltsev.pacmangamenew.Control.PacManController;
import nsu.fit.usoltsev.pacmangamenew.Model.Matrix;

import java.io.*;
import java.util.*;

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

    public void drawScore(int score, long time ) {
        scoreText.setText("Score: " + (score));
        if (score >= Matrix.MAX_SCORE) {
            try {
                root.getChildren().add(FXMLLoader.load(Objects.requireNonNull(HealthView.class.getResource("win.fxml"))));

                setRecord(root, time);

                Button startBtn = (Button) root.lookup("#startButton");
                startBtn.setOnAction(event -> PacManController.newGame());

                Button exitButton = (Button) root.lookup("#exitButton");
                exitButton.setOnAction(event -> System.exit(0));

                Button menuButton = (Button) root.lookup("#menuButton");
                menuButton.setOnAction(event -> PacManController.newMenu());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void setRecord(AnchorPane root, long time) {
        TextField name = (TextField) root.lookup("#nameField");
        Button okButton = (Button) root.lookup("#okButton");
        okButton.setOnAction(event -> {
            if(name.getText().equals("")){
               name.setPromptText("INSERT NAME!");
            }
            else {
                name.setVisible(false);
                okButton.setVisible(false);
                try (BufferedReader recordFile = new BufferedReader(new FileReader("./src/main/resources/nsu/fit/usoltsev/pacmangamenew/records.txt"))) {
                    String line;
                    LinkedHashMap<String, Long> recordMap = new LinkedHashMap<>();
                    while ((line = recordFile.readLine()) != null) {
                        String[] args = line.split("\\s+");
                        recordMap.put(args[0], Long.parseLong(args[1]));
                    }

                    recordMap.put(name.getText(), time / 1_000_000_000);
                    LinkedHashMap<String, Long> result = new LinkedHashMap<>();
                    recordMap.entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByValue())
                            .limit(10)
                            .forEach(e -> result.put(e.getKey(), e.getValue()));

                    BufferedWriter newRecords = new BufferedWriter(new FileWriter("./src/main/resources/nsu/fit/usoltsev/pacmangamenew/records.txt"));
                    for (var pair : result.entrySet()) {
                        newRecords.write(pair.getKey() + " " + pair.getValue() + "\n");
                    }
                    newRecords.close();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        });
    }


}
