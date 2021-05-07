package society;

import tools.Vector;

/**
 * Class Doctor responds to the needs of society to define health status
 * @author Lukasz Michalski
 */
public class Doctor {

    /**
     * Method diagnose object and if necessary - declare dead
     * @param human diagnosed/analyzed object
     */
    public void diagnose(Human human) {

        // conditions of death
        if (human.healthStatus == 1 && human.resistance <= 3){
            human.recoveryTime -= 32;
            if (human.recoveryTime <= 0) {
                human.velocity.reset();
                human.healthStatus = 3;
                human.numInfected--;
            }
        }

        // conditions for really strong people
        else if (human.healthStatus == 1 && human.resistance >= 8){
            human.recoveryTime -= 32;
            if (human.recoveryTime <= 0){
                human.healthStatus = 2;
                human.numInfected--;

                antibodies(human);
                human.antibodies -= 8;

                recoveryTimeExpected(human);
            }
        }

        // conditions for normal people
        else if (human.healthStatus == 1 && human.resistance < 8 && human.resistance > 3){
            human.velocity.div(1.001);
            human.recoveryTime -= 16;
            if (human.recoveryTime <= 0){
                human.velocity.mult(2);
                human.velocity.limit(human.getMaxSpeed());
                human.healthStatus = 2;
                human.numInfected--;

                antibodies(human);
                human.antibodies -= 32;

                recoveryTimeExpected(human);
            }
        }
    }

    public void antibodies(Human human) {
        human.antibodies = (int)Math.random()*5000;
    }

    public void recoveryTimeExpected(Human human) {
        human.recoveryTime = Math.random()*(7000 - 5000 + 1) + 5000;
    }
}
