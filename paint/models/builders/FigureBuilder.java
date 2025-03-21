package models.builders;

import models.figures.IDrawFigure;
import models.strategy.PaintStyleStrategy;

import java.awt.*;

public interface FigureBuilder {
    FigureBuilder setCoordinates(int x1, int y1, int x2, int y2);
    FigureBuilder setColor(Color color);
    FigureBuilder setStyle(PaintStyleStrategy style);
    IDrawFigure build();
}
