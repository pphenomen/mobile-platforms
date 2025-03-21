package models.builders;

import models.figures.IDrawFigure;
import models.figures.Oval;
import models.strategy.NormalStyle;
import models.strategy.PaintStyleStrategy;

import java.awt.*;

public class OvalBuilder implements FigureBuilder {
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

    public OvalBuilder setStyle(PaintStyleStrategy style) {
        this.style = style;
        return this;
    }

    @Override
    public IDrawFigure build() {
        return new Oval(x1, y1, Math.abs(x2 - x1), Math.abs(y2 - y1), color, style);
    }
}
