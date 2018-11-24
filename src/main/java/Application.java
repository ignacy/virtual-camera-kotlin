import camera.Line2D;
import camera.Point2D;
import gui.Canvas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Application {
    private JFrame frame;
    private JPanel canvas;

    public Application() {
        frame = new JFrame();

        frame.setTitle("Wirtualna Kamera");
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ArrayList<Line2D> lines = new ArrayList<>();
        lines.add(new Line2D(new Point2D(10, 10), new Point2D(300, 10)));
        lines.add(new Line2D(new Point2D(10, 20), new Point2D(300, 20)));
        canvas = new Canvas(lines);

        frame.add(canvas);
    }

    public void start() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new Application().start();
        });
    }
}