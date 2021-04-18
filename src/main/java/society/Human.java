package society;

import tools.Vector;
import java.awt.*;

/**
 * class Human is model from which other objects of society inherit.
 * Here the basic human parameters in the simulation are defined.
 * @author Lukasz Michalski
 */
public abstract class Human {
    Vector position;
    Vector velocity;

    /**
     * Default constructor.
     */
    public Human() {
        position = new Vector();
        velocity = new Vector();
    }

    /**
     * Constructor creates a Human object with the specified position and velocity.
     * @param position determines the position of object in space.
     * @param velocity determines the velocity of object.
     */
    public Human(Vector position, Vector velocity) {
        this.position = position;
        this.velocity = velocity;
    }

    /**
     * Method defines the shape of the objects present in the simulation
     * @param g see <a href="https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html">Class Graphics</a>
     */
    protected abstract void render(Graphics g);

}
