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
    protected Vector acceleration;
    protected Integer resistance;
    protected final Integer MAX_RESISTANCE = 10;
    protected int healthStatus; //0 - never sick, 1 - infected, 2 - passed the disease, 3 - dead
    protected Double recoveryTime;
    protected Integer antibodies;
    public static int numInfected = 0;
    private double maxSpeed, maxForce;

    private Doctor doctor = new Doctor();
    private Police policeman = new Police();
    private Logic logic = new Logic();

    /**
     * Default constructor, creates a Human object with the specified but random position and velocity.
     */
    public Human() {
        maxForce = 0.2;
        maxSpeed = 4;
        antibodies = 0;
        acceleration = new Vector();

        double coordinate_x = Math.random() * WIN_WIDTH;
        double coordinate_y = Math.random() * WIN_HEIGHT;
        position = new Vector(coordinate_x, coordinate_y);

        double velocity_x = Math.random() * (maxSpeed) +- 2;
        double velocity_y = Math.random() * (maxSpeed) +- 2;
        velocity = new Vector(velocity_x, velocity_y);

        resistance = (int)(Math.random() * MAX_RESISTANCE);
        // set recovery time
        doctor.recoveryTimeExpected(this);

        //Set how much of society is sick at the very beginning
        if (Math.random() < 0.08) {
            healthStatus = 1;
            numInfected++;
        }
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

        position.add(velocity);
        doctor.diagnose(this);
        policeman.control(this);

        if (resistance <= 1) {
            logic.distanceYourself(this);
            logic.update(this);
        }

        Government.introduceRestrictions(this);
    };

    /**
     * Logic related to contamination of objects
     * @param human
     */
    public void collision(Human human) {
        Rectangle human1 = new Rectangle((int)human.position.x, (int)human.position.y, 10, 10);
        Rectangle human2 = new Rectangle((int)this.position.x, (int)this.position.y, 10, 10);

        if (human1.intersects(human2)) {
            if (this.healthStatus == 1 && (human.healthStatus == 0 || (human.healthStatus == 2 && human.antibodies <= 0))) {
                human.healthStatus = 1;
                numInfected++;
            }

            else if (human.healthStatus == 1 && (this.healthStatus == 0 || (this.healthStatus == 2 && this.antibodies <= 0))) {
                this.healthStatus = 1;
                numInfected++;
            }
        }
    }

    /**
     * @return maximum speed value
     */
    public double getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * @return maximum force value
     */
    public double getMaxForce() {
        return maxForce;
    }

    /**
     * @return content of object acceleration field
     */
    public Vector getAcceleration() {
        return acceleration;
    }

    /**
     * Set content of object acceleration field
     * @param acceleration is new acceleration field vector
     */
    public void setAcceleration(Vector acceleration) {
        this.acceleration = acceleration;
    }
}
