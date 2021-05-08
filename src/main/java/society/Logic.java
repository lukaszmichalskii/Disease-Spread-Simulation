package society;

import tools.Vector;

import java.awt.*;

import static gui.Panel.people;
import static society.Doctor.numInfected;

/**
 * Class Logic defines decisions that can be made by the objects of society
 */
public class Logic {

    /**
     * Method defines the logic of social distancing behavior
     * @param human considered object
     * @return steering is vector which stores information about force of social distancing
     */
    public static Vector socialDistancing(Human human) {
        int perceptionRadius = 30;
        int total = 0;
        double dist;
        Vector steering = new Vector();

        for (Human humanEntity: people) {
            if (humanEntity.healthStatus != 3 && human.healthStatus != 3) {
                dist = Vector.dist(human.position, humanEntity.position);
                if (dist < perceptionRadius && human != humanEntity) {
                    Vector diff = new Vector(human.position.x, human.position.y);
                    diff.sub(humanEntity.position);
                    diff.div(dist);
                    steering.add(diff);
                    total++;
                }
            }
        }
        if (total > 0) {
            steering.div(total);
            steering.sub(human.velocity);
            steering.mult(human.getMaxSpeed());
            steering.limit(human.getMaxForce());
        }
        return steering;
    }

    /**
     * Defines what will be done if human realizes the danger posed by the disease
     * @param human
     */
    public static void distanceYourself(Human human) {
        human.setAcceleration(new Vector());
        Vector socialDistancing = socialDistancing(human);
        human.setAcceleration(socialDistancing);
    }

    /**
     * Update the human object fields
     * @param human
     */
    public static void update(Human human) {
        human.velocity.add(human.getAcceleration());
        human.velocity.limit(human.getMaxSpeed());
    }

    /**
     * Logic related to contamination of objects
     * @param human1
     * @param human2
     */
    public static void collision(Human human1, Human human2) {
        Rectangle human1Radius = new Rectangle((int)human2.position.x, (int)human2.position.y, 10, 10);
        Rectangle human2Radius = new Rectangle((int)human1.position.x, (int)human1.position.y, 10, 10);

        if (human1Radius.intersects(human2Radius)) {
            if (human1.healthStatus == 1 && (human2.healthStatus == 0 || (human2.healthStatus == 2 && human2.antibodies <= 0))) {
                human2.healthStatus = 1;
                numInfected++;
            }

            else if (human2.healthStatus == 1 && (human1.healthStatus == 0 || (human1.healthStatus == 2 && human1.antibodies <= 0))) {
                human1.healthStatus = 1;
                numInfected++;
            }
        }
    }
}
