package models.builders;

import models.figures.Circle;
import models.figures.IDrawFigure;
import models.strategy.NormalStyle;
import models.strategy.PaintStyleStrategy;

import java.awt.*;

public class CircleBuilder implements FigureBuilder {
    private int x1, y1, x2, y2;
    private int fixedRadius = -1; // -1 = не задан
    private Color color = Color.BLACK;
    private PaintStyleStrategy style = new NormalStyle();

    public CircleBuilder setFixedRadius(int radius) {
        this.fixedRadius = radius;
        return this;
    }

    @Override
    public FigureBuilder setCoordinates(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        return this;
    }

    @Override
    public FigureBuilder setColor(Color color) {
        this.color = color;
        return this;
    }

    public CircleBuilder setStyle(PaintStyleStrategy style) {
        this.style = style;
        return this;
    }

    @Override
    public IDrawFigure build() {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int diameter = Math.min(dx, dy);
        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);
        return new Circle(x, y, diameter, color, style);
    }
}
