package nsu.fit.usoltsev.pacmangamenew.View;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import nsu.fit.usoltsev.pacmangamenew.Control.PacManController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class RecordsVIew {
    public static void viewRecord(AnchorPane root) {
        try (BufferedReader recordFile = new BufferedReader(new FileReader("./src/main/resources/nsu/fit/usoltsev/pacmangamenew/records.txt"))) {
            root.getChildren().add(FXMLLoader.load(Objects.requireNonNull(RecordsVIew.class.getResource("record.fxml"))));
            String line;
            LinkedHashMap<String, Long> recordMap = new LinkedHashMap<>();
            while ((line = recordFile.readLine()) != null) {
                String[] args = line.split("\\s+");
                recordMap.put(args[0], Long.parseLong(args[1]));
            }

            TableView<Map.Entry<String, Long>> tableView = (TableView<Map.Entry<String, Long>>) root.lookup("#recordTable");
            TableColumn<Map.Entry<String, Long>, String> nameColumn = (TableColumn<Map.Entry<String, Long>, String>) tableView.getColumns().get(0);
            TableColumn<Map.Entry<String, Long>, Long> timeColumn = (TableColumn<Map.Entry<String, Long>, Long>) tableView.getColumns().get(1);
            nameColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getKey()));
            timeColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getValue()));
            ObservableList<Map.Entry<String, Long>> entryObservableList = FXCollections.observableArrayList(recordMap.entrySet());
            tableView.setItems(entryObservableList);

            Button menuButton = (Button) root.lookup("#menuButton");
            menuButton.setOnAction(event -> PacManController.newMenu());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
