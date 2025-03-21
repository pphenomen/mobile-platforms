package paint;

import java.awt.*;

public class ThickStyle implements PaintStyleStrategy {
    @Override
    public void apply(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(5));
    }
}
