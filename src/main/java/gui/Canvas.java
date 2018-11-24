package gui;

import camera.Line2D;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Scene?
public class Canvas extends JPanel {
    private ArrayList<Line2D> lines;

    // FIXME: w przyszlosci powinno brac obiekty 2d
    // do narysowania
    public Canvas(ArrayList<Line2D> lines) {
        this.lines = lines;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        for (Line2D line: lines) {
            line.draw(graphics);
        }
    }
}
