package camera;

import java.util.ArrayList;

public class Scene {
    private ArrayList<Line3D> lines;
    private int x, z;

    public Scene(ArrayList<Line3D> lines) {
        this.lines = lines;
        this.x = Camera.WIDTH / 2;
        this.z = Camera.HEIGHT / 2;
    }

}