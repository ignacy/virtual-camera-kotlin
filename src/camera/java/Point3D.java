package camera;

public class Point3D {
    private Double[] vector;

    public Point3D (double x, double y, double z) {
        v = new Double[4];
        v[0] = x;
        v[1] = y;
        v[2] = z;
        v[3] = 1.0;
    }
}
