package paint;

import java.awt.*;

public class Line implements IDrawFigure {
    private int x1, y1, x2, y2;
    private Color color;
    private PaintStyleStrategy style;

    public Line(int x1, int y1, int x2, int y2, Color color, PaintStyleStrategy style) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        this.style = style;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        style.apply(g2d);
        g2d.drawLine(x1, y1, x2, y2);
        g2d.setStroke(new BasicStroke(1)); // сброс
    }
}
