package camera;

public class Camera {
    private double planeDistance;
    private double y;

    public Camera(double planeDistance, double y) {
        this.setPlaneDistance(planeDistance);
        this.setY(y);
    }

    public double getPlaneDistance() {
        return planeDistance;
    }

    public void setPlaneDistance(double planeDistance) {
        this.planeDistance = planeDistance;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}