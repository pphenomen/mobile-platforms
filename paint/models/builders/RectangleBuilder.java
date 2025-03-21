package models.builders;

import models.figures.IDrawFigure;
import models.figures.Rectangle;
import models.strategy.NormalStyle;
import models.strategy.PaintStyleStrategy;

import java.awt.*;

public class RectangleBuilder implements FigureBuilder {
    private int x1, y1, x2, y2;
    private Color color = Color.BLACK;
    private PaintStyleStrategy style = new NormalStyle();

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

    public RectangleBuilder setStyle(PaintStyleStrategy style) {
        this.style = style;
        return this;
    }

    @Override
    public IDrawFigure build() {
        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);
        int width = Math.abs(x2 - x1);
        int height = Math.abs(y2 - y1);
        return new Rectangle(x, y, width, height, color, style);
    }
}
