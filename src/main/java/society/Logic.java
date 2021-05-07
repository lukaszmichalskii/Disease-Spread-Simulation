package society;

import tools.Vector;

import static main.Panel.people;

/**
 * Class Logic defines decisions that can be made by the objects of society
 */
public class Logic {
    private Doctor doctor = new Doctor();

    /**
     * Method defines the logic of social distancing behavior
     * @param human considered object
     * @return steering is vector which stores information about force of social distancing
     */
    public Vector socialDistancing(Human human) {
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
    public void distanceYourself(Human human) {
        human.setAcceleration(new Vector());
        Vector socialDistancing = socialDistancing(human);
        human.setAcceleration(socialDistancing);
    }

    /**
     * Update the human object fields
     * @param human
     */
    public void update(Human human) {
        human.velocity.add(human.getAcceleration());
        human.velocity.limit(human.getMaxSpeed());
    }

}
