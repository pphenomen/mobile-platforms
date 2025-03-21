package models.figures;

import models.strategy.PaintStyleStrategy;

import java.awt.*;

public class Oval implements IDrawFigure {
    private int x, y, width, height;
    private Color color;
    private PaintStyleStrategy style;

    public Oval(int x, int y, int width, int height, Color color, PaintStyleStrategy style) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.style = style;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        style.apply(g2d);
        g.drawOval(x, y, width, height);
    }
}
