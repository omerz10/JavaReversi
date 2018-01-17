package GUI;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 * Created by david on 17/01/2018.
 */
public class GUICircle extends Circle {
    public GUICircle(int centerX, int centerY, int radius, Paint fill) {
        super(centerX, centerY, radius, fill);
    }

    public void draw() {
        this.setStroke(Color.BLACK);
    }
}
