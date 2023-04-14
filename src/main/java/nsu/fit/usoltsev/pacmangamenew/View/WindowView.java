package nsu.fit.usoltsev.pacmangamenew.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import nsu.fit.usoltsev.pacmangamenew.Main;
import nsu.fit.usoltsev.pacmangamenew.Model.*;

import java.io.File;
import java.io.IOException;

public class WindowView {
    public static void setWindowOptions(Stage stage, Scene scene) {
        scene.setFill(Color.rgb(2, 0, 9));
        File iconFile = new File("./src/main/resources/pictures/PacManPictures/PacmanRight.png");
        Image icon = new Image(iconFile.toURI().toString());
        stage.getIcons().add(icon);
        stage.setTitle("Pac Man");
    }

    public static Scene startView(Group root, Button startBtn) {
//        try {
//            Parent menuRoot = FXMLLoader.load((Main.class.getResource("menu.fxml")));
//            return new Scene(menuRoot);
//        } catch (IOException r) {
//            System.out.println("hi");
//        }

        File logoFile = new File("./src/main/resources/pictures/PacmanLogo.png");
        Image logoImage = new Image(logoFile.toURI().toString());
        ImageView logoView = new ImageView(logoImage);
        double aspectRatio = logoImage.getWidth() / logoImage.getHeight();
        logoView.setFitHeight(600 / aspectRatio);
        logoView.setFitWidth(600);
        logoView.setX(25);
        logoView.setY(25);
        root.getChildren().add(logoView);

        File imageFile = new File("./src/main/resources/pictures/Start.png");
        Image btnImage = new Image(imageFile.toURI().toString());
        ImageView imageView = new ImageView(btnImage);
         aspectRatio = btnImage.getWidth() / btnImage.getHeight();
        imageView.setFitHeight(200 / aspectRatio);
        imageView.setFitWidth(200);
        startBtn.setGraphic(imageView);
//        startBtn = new Button("", imageView);
        startBtn.setLayoutX(250);
        startBtn.setLayoutY(300);
        root.getChildren().add(startBtn);

        return null;
    }
}
