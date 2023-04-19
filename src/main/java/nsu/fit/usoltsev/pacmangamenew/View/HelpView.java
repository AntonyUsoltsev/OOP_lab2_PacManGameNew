package nsu.fit.usoltsev.pacmangamenew.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import nsu.fit.usoltsev.pacmangamenew.Control.PacManController;

import java.io.IOException;
import java.util.Objects;

public class HelpView {
    public static void viewHelp(AnchorPane root)  {
        try {
            root.getChildren().add(FXMLLoader.load(Objects.requireNonNull(HelpView.class.getResource("help.fxml"))));
            Button menuButton = (Button) root.lookup("#menuButton");
            menuButton.setOnAction(event -> PacManController.newMenu());
        }catch (IOException e){
            throw new RuntimeException(e);

        }
    }
}
