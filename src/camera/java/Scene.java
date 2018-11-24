package camera;

import java.util.ArrayList;

public class Scene {
    private ArrayList<Line3D> lines;
    private int x, z;
    public static final int HEIGHT = 600;
    public static final int WIDTH = 600;

    public Scene(ArrayList<Line3D> lines) {
        this.lines = lines;
        this.x = WIDTH / 2;
        this.z = HEIGHT / 2;
    }

}