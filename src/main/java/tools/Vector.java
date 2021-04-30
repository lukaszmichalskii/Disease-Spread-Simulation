package tools;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * The Vector class is the tool that creates a vector object in two-dimensional space known from linear algebra.
 * @author Lukasz Michalski
 */
public class Vector {

    public double x, y;

    /**
     * Default constructor
     */
    public Vector() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Constructor create Vector object based on vector coordinates.
     * @param x is coordinate x on the abscissa (refers to the horizontal (x) axis).
     * @param y is coordinate y on the ordinate (refers to the vertical (y) axis).
     */
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Add method responsible for adding one vector object to another
     * @param vector
     */
    public void add(Vector vector) {
        x += vector.x;
        y += vector.y;
    }

    public void sub(Vector vector) {
        x -= vector.x;
        y -= vector.y;
    }

    public void mult(double value) {
        x *= value;
        y *= value;
    }

    public void div(double value){
        x /= value;
        y /= value;
    }

    public void reset() {
        x = 0;
        y = 0;
    }

    double magnitude() {
        return sqrt(pow(x, 2) + pow(y, 2));
    }

    public void limit(double lim) {
        double magnitude = magnitude();
        if (magnitude != 0 && magnitude > lim) {
            x *= lim / magnitude;
            y *= lim / magnitude;
        }
    }

    public static double dist(Vector v1, Vector v2) {
        return sqrt(pow(v1.x - v2.x, 2) + pow(v1.y - v2.y, 2));
    }
}
