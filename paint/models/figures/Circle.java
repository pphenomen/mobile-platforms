package models.figures;

import models.strategy.PaintStyleStrategy;

import java.awt.*;

public class Circle implements IDrawFigure {
    private int x, y, diameter;
    private Color color;
    private PaintStyleStrategy style;

    public Circle(int x, int y, int diameter, Color color, PaintStyleStrategy style) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.color = color;
        this.style = style;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        style.apply(g2d);
        g.drawOval(x, y, diameter, diameter);
    }
}
