package camera;

public class Point3D {
    private Double[] vector;

    public Point3D (double x, double y, double z) {
        vector = new Double[4];
        vector[0] = x;
        vector[1] = y;
        vector[2] = z;
        vector[3] = 1.0;
    }
}
