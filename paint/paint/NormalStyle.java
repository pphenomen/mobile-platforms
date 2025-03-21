package paint;

import java.awt.*;

public class NormalStyle implements PaintStyleStrategy{
    @Override
    public void apply(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(1));
    }
}
