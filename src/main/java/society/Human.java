package society;

import tools.Vector;
import java.awt.*;

import static main.Screen.WIN_HEIGHT;
import static main.Screen.WIN_WIDTH;

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
        double coordinate_x = Math.random() * WIN_WIDTH;
        double coordinate_y = Math.random() * WIN_HEIGHT;
        position = new Vector(coordinate_x, coordinate_y);

        double velocity_x = Math.random() * (10 + 1) +- 5;
        double velocity_y = Math.random() * (10 + 1) +- 5;
        velocity = new Vector(velocity_x, velocity_y);
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
     * @param graphics see <a href="https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html">Class Graphics</a>
     */
    public void paint(Graphics graphics){
        graphics.setColor(Color.GRAY);

        edges();
        graphics.fillOval((int) position.x, (int) position.y, 7, 7);
    };

    /**
     * Method responsible for controlling whether objects do not go beyond the designated area
     */
    public void edges() {
        
        if (checkX())
            velocity.x *= -1;

        if (checkY())
            velocity.y *= -1;
    }

    /**
     * Method check if horizontal coordinate of object position is in designated area
     * @return statement of condition being in designated area (horizontal)
     */
    public boolean checkX() {
        return position.x < 0 || position.x > WIN_WIDTH;
    }

    /**
     * Method check if vertical coordinate of object position is in designated area
     * @return statement of condition being in designated area (vertical)
     */
    public boolean checkY() {
        return position.y < 0 || position.y > WIN_HEIGHT;
    }
}
