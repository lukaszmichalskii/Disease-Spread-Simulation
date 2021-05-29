package society;

import java.awt.*;

import static disease.DiseaseSpreader.initial_numInfected;
import static gui.Panel.map;
import static society.Doctor.numInfected;
import static society.Government.peoplePayAttention;

/**
 * class Human is model from which other objects of society inherit.
 * Here the basic human parameters in the simulation are defined.
 * @author Lukasz Michalski
 */
public abstract class Human implements IHuman {

    protected int resistance;
    protected final int MAX_RESISTANCE = 10;
    protected int healthStatus; // 0 - never sick, 1 - infected, 2 - passed the disease, 3 - dead
    protected double recoveryTime;
    protected double antibodies;
    protected int numSick = 0;

    /**
     * Default constructor, creates a Human object with the specified but random position and velocity.
     */
    public Human() {
        antibodies = 0;

        resistance = (int)(Math.random() * MAX_RESISTANCE);
        // set recovery time
        Doctor.recoveryTimeExpected(this);

        // set how much of society is sick at the very beginning
        if (Math.random() < initial_numInfected) {
            healthStatus = 1;
            numInfected++;
            numSick++;
        }
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

        map.setPosition(this, map.getPosition(this).addR(map.getVelocity(this)));

        if (Math.random() < peoplePayAttention) {
            Logic.distanceYourself(this);
            Logic.update(this);
        }
    }

    /**
     * @return resistance of human
     */
    public int getResistance() {
        return resistance;
    }

    /**
     * @return health status of human
     */
    public int getHealthStatus() {
        return healthStatus;
    }

    /**
     * Set new health status of human
     * @param healthStatus parameter we want to set
     */
    public void setHealthStatus(int healthStatus) {
        this.healthStatus = healthStatus;
    }

    /**
     * @return antibodies of human
     */
    public double getAntibodies() {
        return antibodies;
    }

    /**
     * Function count how many times person was infected
     */
    public void increaseNumSick() {
        this.numSick++;
    }
}
