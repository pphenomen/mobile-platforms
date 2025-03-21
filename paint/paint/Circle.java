package paint;

import java.awt.*;

public class Circle implements IDrawFigure {
    private int x, y, diameter;

    public Circle(int x, int y, int diameter) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.drawOval(x, y, diameter, diameter);
    }
}
