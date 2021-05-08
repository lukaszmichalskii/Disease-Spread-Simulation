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
     * Add method
     * @param vector is object we want to add to our original
     */
    public void add(Vector vector) {
        x += vector.x;
        y += vector.y;
    }

    /**
     * Substract method
     * @param vector is object we want to substract to our original
     */
    public void sub(Vector vector) {
        x -= vector.x;
        y -= vector.y;
    }

    /**
     * Scalar multiplication method
     * @param value our scalar
     */
    public void mult(double value) {
        x *= value;
        y *= value;
    }

    /**
     * Division by a scalar method
     * @param value our scalar
     */
    public void div(double value){
        x /= value;
        y /= value;
    }

    /**
     * Method responsible for reset vector components
     */
    public void reset() {
        x = 0;
        y = 0;
    }

    /**
     * Calculate magnitude of vector
     * @return magnitude of vector
     */
    public double magnitude() {
        return sqrt(pow(x, 2) + pow(y, 2));
    }

    /**
     * Method responsible for the vector constraint
     * @param lim value we do not want to pass
     */
    public void limit(double lim) {
        double magnitude = magnitude();
        if (magnitude != 0 && magnitude > lim) {
            x *= lim / magnitude;
            y *= lim / magnitude;
        }
    }

    /**
     * Calculate distance between vector objects, the considered vectors are parameters
     * @param v1
     * @param v2
     * @return
     */
    public static double dist(Vector v1, Vector v2) {
        return sqrt(pow(v1.x - v2.x, 2) + pow(v1.y - v2.y, 2));
    }
}
