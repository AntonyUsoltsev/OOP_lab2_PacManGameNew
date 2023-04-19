package nsu.fit.usoltsev.pacmangamenew.View;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TimeView {
    private final Text time;
    public TimeView(AnchorPane root) {
        time = new Text(500, 20, "");
        time.setFill(Color.YELLOW);
        time.setFont(new Font(20));
        root.getChildren().add(time);
    }

    public void drawTime(long curTime) {
        time.setText("Time: " + (curTime / 1_000_000_000) + " sec");
    }
}
