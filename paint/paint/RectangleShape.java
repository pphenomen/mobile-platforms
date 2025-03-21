package paint;

import java.awt.*;

public class RectangleShape implements IDrawFigure {
    private int x, y, width, height;

    public RectangleShape(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawRect(x, y, width, height);
    }
}
