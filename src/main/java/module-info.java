module nsu.fit.usoltsev.pacmangamenew {
    requires javafx.controls;
    requires javafx.fxml;

    opens nsu.fit.usoltsev.pacmangamenew to javafx.fxml;
    exports nsu.fit.usoltsev.pacmangamenew;

    opens nsu.fit.usoltsev.pacmangamenew.Control to javafx.fxml;
    exports nsu.fit.usoltsev.pacmangamenew.Control;
}