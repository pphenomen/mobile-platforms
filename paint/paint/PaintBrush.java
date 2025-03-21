package paint;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PaintBrush implements IDrawFigure {
    private List<Point> points = new ArrayList<>();
    private Color color;
    private PaintStyleStrategy style;

    public PaintBrush(Color color, PaintStyleStrategy style) {
        this.color = color;
        this.style = style;
    }

    public void addPoint(int x, int y) {
        points.add(new Point(x, y));
    }

    @Override
    public void draw(Graphics g) {
        if (points.size() < 2) return;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        style.apply(g2d);

        for (int i = 1; i < points.size(); i++) {
            Point p1 = points.get(i - 1);
            Point p2 = points.get(i);
            g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
        }

        g2d.setStroke(new BasicStroke()); // сброс
    }
}
