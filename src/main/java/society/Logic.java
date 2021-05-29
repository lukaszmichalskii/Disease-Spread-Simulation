package society;

import tools.Vector;

import static gui.Panel.map;


import static gui.Panel.people;

/**
 * Class Logic defines decisions that can be made by the objects of society
 * @author Lukasz Michalski
 */
public class Logic {

    public static double maxSpeed = 5;
    public static double maxForce = 0.5;

    /**
     * Method defines the logic of social distancing behavior
     * @param human considered object
     * @return steering is vector which stores information about force of social distancing
     */
    public static Vector socialDistancing(Human human) {
        int perceptionRadius = 20;
        int total = 0;
        double dist;
        Vector steering = new Vector();

        for (Human humanEntity: people) {

            /*
            Skip the deceased person pay attention only to living people.
            You do not know anything about met person, he/she could be sick and has antibodies or
            never been sick but you know that he/she may be virus carrier like in real life.
            */
            if (humanEntity.healthStatus != 3 && human.healthStatus != 3) {
                dist = Vector.dist(map.getPosition(human), map.getPosition(humanEntity));
//                dist = Vector.dist(human.position, humanEntity.position);
                if (dist < perceptionRadius && human != humanEntity) {
                    Vector diff = new Vector(map.getPosition(human).x, map.getPosition(human).y);
//                    Vector diff = new Vector(human.position.x, human.position.y);
                    diff.sub(map.getPosition(humanEntity));
//                    diff.sub(humanEntity.position);
                    diff.div(dist);
                    steering.add(diff);
                    total++;
                }
            }
        }
        if (total > 0) {
            steering.div(total);
            steering.sub(map.getVelocity(human));
            steering.mult(maxSpeed);
            steering.limit(maxForce);
        }
        return steering;
    }

    /**
     * Defines what will be done if human realizes the danger posed by the disease
     * @param human an object that will begin to distance itself when the method is called
     */
    public static void distanceYourself(Human human) {
        map.setAcceleration(human, new Vector());
//        human.setAcceleration(new Vector());
        Vector socialDistancing = socialDistancing(human);
        map.setAcceleration(human, socialDistancing);
//        human.setAcceleration(socialDistancing);
    }

    /**
     * Update the human object fields
     * @param human object that will update parameters when the method is called
     */
    public static void update(Human human) {
        map.setVelocity(human, map.getVelocity(human).addR(map.getAcceleration(human)));
//        human.velocity.add(human.getAcceleration());
        map.setVelocity(human, map.getVelocity(human).limitR(maxSpeed));
//        human.velocity.limit(maxSpeed);
    }
}
