package nsu.fit.usoltsev.pacmangamenew;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import nsu.fit.usoltsev.pacmangamenew.Control.PacManController;
import nsu.fit.usoltsev.pacmangamenew.Model.DotModel;
import nsu.fit.usoltsev.pacmangamenew.Model.FieldModel;
import nsu.fit.usoltsev.pacmangamenew.Model.Matrix;
import nsu.fit.usoltsev.pacmangamenew.View.WindowView;

import java.io.IOException;
import java.util.Objects;


public class Main extends javafx.application.Application {
    public static void main(String[] args) {
      launch();
    }

    private static void test2(Number a) {
        System.out.println(a.getClass().getName());
        test1(a);
    }
    private static void test1(Integer x) {
        System.out.println("Integer");
    }

    private static void test1(Number x) {
        System.out.println("Number");
    }



    @Override
    public void start(Stage stage) throws IOException {
//
////        FXMLLoader loader = new FXMLLoader();
////        URL xmlUrl = getClass().getResource("menu.fxml");
////        System.out.println(xmlUrl);
////
////        loader.setLocation(xmlUrl);
////        Parent menuRoot = loader.load();
//
////        File iconFile = new File("./src/main/resources/menu.fxml");
////        System.out.println(iconFile);
////        FXMLLoader fxmlLoader = new FXMLLoader(iconFile.toURL());
////        System.out.println(fxmlLoader);
////        Scene scene = new Scene(fxmlLoader.load());
////        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
////        Parent menuRoot = loader.load();
////        Scene scene = new Scene(menuRoot);
//          Button startBtn = new Button();
//        scene = WindowView.startView();
//


        Group root = new Group();
        Scene scene = new Scene(root, Matrix.CELL_SIZE * Matrix.CELL_X_COUNT, Matrix.CELL_SIZE * Matrix.CELL_Y_COUNT);
        WindowView.setWindowOptions(stage, scene);


        Button startBtn = new Button();
        WindowView.startView(root,startBtn);

        startBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startBtn.setVisible(false);

                FieldModel.viewField(root);
                DotModel.setDots(root);
                PacManController pacManController = new PacManController(root);
                pacManController.control(scene);
            }

        });
        stage.setScene(scene);
        stage.show();
    }


}