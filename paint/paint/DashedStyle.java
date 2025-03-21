package paint;

import java.awt.*;

public class DashedStyle implements PaintStyleStrategy{
    @Override
    public void apply(Graphics2D g2d) {
        float[] dash = {5f};
        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, dash, 0));
    }
}
