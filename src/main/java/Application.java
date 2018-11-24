import java.awt.EventQueue;
import javax.swing.*;

public class Application {
    private JFrame frame;

    public Application() {
        frame = new JFrame();

        frame.setTitle("Wirtualna Kamera");
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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