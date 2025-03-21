package paint;

import java.awt.*;

public class Oval implements IDrawFigure {
    private int x, y, width, height;

    public Oval(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.drawOval(x, y, width, height);
    }
}
