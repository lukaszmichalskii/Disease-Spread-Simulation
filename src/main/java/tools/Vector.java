package tools;

/**
 * The Vector class is the tool that creates a vector object in two-dimensional space known from linear algebra.
 * @author Lukasz Michalski
 */
public class Vector {
    double x, y;

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
}
