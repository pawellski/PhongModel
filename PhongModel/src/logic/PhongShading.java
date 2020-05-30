package logic;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class PhongShading {

    private static Point3D lightSource = new Point3D(0, 0, 200);

    private static final double Ia = 100;
    private static final double Ip = 60000;

    private static final int STEP = 10;

    public static void phongAlgoritm(GraphicsContext image, Surface surface) {
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        PixelReader reader = image.getCanvas().snapshot(params, null).getPixelReader();
        PixelWriter pw = image.getPixelWriter();

        for (int i = 0; i < 500; i++) {
            for (int j = 0; j < 500; j++) {
                if (!reader.getColor(i, j).toString().equals("0x000000ff")) {
                    Point3D point = computeZ(i, j);
                    Vector vN = point.convertToVector();
                    vN.normalize();
                    Vector vL = computeVector(point, lightSource);
                    vL.normalize();

                    double I = lightIntensity(surface, point, vN, vL);
                    Color actualColor = reader.getColor(i, j);
                    int red = assignColor((int) (actualColor.getRed() * 255), I);
                    int green = assignColor((int) (actualColor.getGreen() * 255), I);
                    int blue = assignColor((int) (actualColor.getBlue() * 255), I);

                    Color newColor = Color.rgb(red, green, blue);
                    pw.setColor(i, j, newColor);
                }

            }
        }
    }

    private static int assignColor(int component, double I) {
        int newColor = component + (int) I;
        if (newColor < 0) {
            newColor = 0;
        } else if (newColor > 255) {
            newColor = 255;
        }
        return newColor;
    }

    private static Point3D computeZ(int x, int y) {
        x = x - 250;
        y = y - 250;
        return new Point3D(x, y, (int) Math.sqrt(150 * 150 - x * x - y * y));
    }

    private static Vector computeVector(Point3D p1, Point3D p2) {
        return new Vector(p2.getX() - p1.getX(), p2.getY() - p1.getY(), p2.getZ() - p1.getZ());
    }

    private static double computeFatt(Point3D p) {
        double distance = Math.pow(p.getX() + lightSource.getX(), 2) + Math.pow(p.getY() + lightSource.getY(), 2) + Math.pow(p.getZ() + lightSource.getZ(), 2);
        return 1.0 / Math.sqrt(distance);

    }

    private static double computeCos(Vector a, Vector b) {
        double distance = Math.sqrt(a.getX() * a.getX() + a.getY() * a.getY() + a.getZ() * a.getZ())
                * Math.sqrt(b.getX() * b.getX() + b.getY() * b.getY() + b.getZ() * b.getZ());
        if (a.mulitplyScalarVectorByVector(b) > 0) {
            return 0;
        }
        return a.mulitplyScalarVectorByVector(b) / distance;
    }

    private static double lightIntensity(Surface surface, Point3D point, Vector vN, Vector vL) {
        return Ia * surface.getKA()
                + computeFatt(point) * Ip * surface.getKD() * vN.mulitplyScalarVectorByVector(vL)
                + computeFatt(point) * Ip * surface.getKS() * Math.pow(computeCos(computeVector(lightSource, point), vN), surface.getN());
    }

    public static void moveUp() {
        lightSource.setY(lightSource.getY() - STEP);
    }

    public static void moveDown() {
        lightSource.setY(lightSource.getY() + STEP);
    }

    public static void moveLeft() {
        lightSource.setX(lightSource.getX() - STEP);
    }

    public static void moveRight() {
        lightSource.setX(lightSource.getX() + STEP);
    }

    public static void moveForward() {
        if (lightSource.getZ() != 150) {
            lightSource.setZ(lightSource.getZ() - STEP);
        }
    }

    public static void moveBackward() {
        lightSource.setZ(lightSource.getZ() + STEP);
    }

}
