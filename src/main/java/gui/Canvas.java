package gui;

import camera.Line2D;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Canvas extends JPanel {
    private ArrayList<Line2D> lines;

    // FIXME: powinien brac Scene
    public Canvas(ArrayList<Line2D> lines) {
        this.lines = lines;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        // FIXME: scene.draw(graphics)
        for (Line2D line: lines) {
            line.draw(graphics);
        }
    }
}
