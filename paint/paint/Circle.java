package paint;

import java.awt.*;

public class Circle implements IDrawFigure {
    private int x, y, diameter;
    private Color color;

    public Circle(int x, int y, int diameter, Color color) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.color = color;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawOval(x, y, diameter, diameter);
    }
}
