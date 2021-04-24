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

    protected Vector position;
    protected Vector velocity;
    protected Integer resistance;
    protected final Integer MAX_RESISTANCE = 10;
    protected boolean isInfected = false;
    protected int healthStatus; //0 - never sick, 1 - infected, 2 - passed the disease, 3 - dead
    protected Double recoveryTime;

    /**
     * Default constructor, creates a Human object with the specified but random position and velocity.
     */
    public Human() {

        double coordinate_x = Math.random() * WIN_WIDTH;
        double coordinate_y = Math.random() * WIN_HEIGHT;
        position = new Vector(coordinate_x, coordinate_y);

        double velocity_x = Math.random() * (5 + 1) +- 2;
        double velocity_y = Math.random() * (5 + 1) +- 2;
        velocity = new Vector(velocity_x, velocity_y);

        resistance = (int)(Math.random() * MAX_RESISTANCE);
        recoveryTime = Math.random()*(7000 - 5000 + 1) + 5000;

        //Set how much of society is sick
        if (Math.random() < 0.08)
            healthStatus = 1;
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
     * Method simulate behavior of society based on all defined rules like area boundaries, is object infected etc.
     * @param graphics see <a href="https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html">Class Graphics</a>
     */
    public void paint(Graphics graphics){
        switch (healthStatus) {
            case 0 -> graphics.setColor(Color.GRAY);
            case 1 -> graphics.setColor(Color.RED);
            case 2 -> graphics.setColor(Color.GREEN);
            case 3 -> graphics.setColor(Color.BLACK);
        }

        if (healthStatus == 1 && resistance <= 3){
            recoveryTime -= 32;
            if (recoveryTime <= 0) {
                velocity.reset();
                healthStatus = 3;
            }
        }

        else if (healthStatus == 1 && resistance >= 8){
            recoveryTime -= 32;
            if (recoveryTime <= 0){
                healthStatus = 2;
            }

        }
        else if (healthStatus == 1 && resistance < 8 && resistance > 3){
            velocity.div(1.001);
            recoveryTime -= 16;
            if (recoveryTime <= 0){
                velocity.mult(2);
                healthStatus = 2;
            }
        }

        position.add(velocity);
        edges();
    };

    public void collision(Human human) {
        Rectangle human1 = new Rectangle((int)human.position.x, (int)human.position.y, 10, 10);
        Rectangle human2 = new Rectangle((int)this.position.x, (int)this.position.y, 10, 10);

        if (human1.intersects(human2)) {
            if (this.healthStatus == 1 && human.healthStatus == 0)
                human.healthStatus = 1;

            else if (this.healthStatus == 0 && human.healthStatus == 1)
                this.healthStatus = 1;
        }
    }

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
