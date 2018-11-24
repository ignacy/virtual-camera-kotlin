package camera;

import java.awt.*;

public class Line2D {
    private Point2D start;
    private Point2D end;

    public Line2D(Point2D start, Point2D end) {
        this.start = start;
        this.end = end;
    }

    public void draw(Graphics g) {
        // FIXME: Cant use double to draw, wtf
        g.drawLine((int) this.start.getX(), (int) this.start.getY(), (int) this.end.getX(), (int) this.end.getY());
    }
}
