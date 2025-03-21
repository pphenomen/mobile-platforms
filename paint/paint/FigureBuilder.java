package paint;

import java.awt.*;

public interface FigureBuilder {
    FigureBuilder setCoordinates(int x1, int y1, int x2, int y2);
    FigureBuilder setColor(Color color);
    FigureBuilder setStyle(PaintStyleStrategy style);
    IDrawFigure build();
}
