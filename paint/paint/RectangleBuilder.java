package paint;

import java.awt.*;

public class RectangleBuilder implements FigureBuilder {
    private int x1, y1, x2, y2;
    private Color color = Color.BLACK;

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

    @Override
    public IDrawFigure build() {
        int size = Math.abs(x2 - x1);
        return new RectangleShape(x1, y1, size, size, color);
    }
}
