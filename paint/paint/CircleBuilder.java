package paint;

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
        int diameter = fixedRadius > 0 ? fixedRadius : Math.abs(x2 - x1);
        int x = x1 - (diameter / 2);
        int y = y1 - (diameter / 2);
        return new Circle(x, y, diameter, color, style);
    }
}
