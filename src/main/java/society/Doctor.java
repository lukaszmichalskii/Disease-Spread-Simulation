package society;

import static disease.DiseaseSpreader.*;

/**
 * Class Doctor responds to the needs of society to define health status
 * @author Lukasz Michalski
 */
public class Doctor {

    public static int numInfected = 0;
    public static int numDead = 0;

    /**
     * Method diagnose object and if necessary - declare dead
     * @param human diagnosed/analyzed object
     */
    public static void diagnose(Human human) {
        int fastTimeDelta = 32;
        int normalTimeDelta = 16;

        // conditions of death
        if (human.healthStatus == 1 && human.resistance <= DISEASE_MORTALITY_INDEX){
            human.recoveryTime -= fastTimeDelta;
            if (human.recoveryTime <= 0) {
                human.velocity.reset();
                human.healthStatus = 3;
                numInfected--;

                numDead++;
            }
        }

        // conditions for really strong people
        else if (human.healthStatus == 1 && human.resistance >= SAFE_LEVEL_IMMUNITY){
            human.recoveryTime -= fastTimeDelta;
            if (human.recoveryTime <= 0){
                human.healthStatus = 2;
                numInfected--;

                antibodies(human);
                human.antibodies--;

                recoveryTimeExpected(human);
            }
        }

        // conditions for normal people
        else if (human.healthStatus == 1 && human.resistance < SAFE_LEVEL_IMMUNITY && human.resistance > DISEASE_MORTALITY_INDEX){
            human.velocity.div(1.001);
            human.recoveryTime -= normalTimeDelta;
            if (human.recoveryTime <= 0){
                human.velocity.mult(2);
                human.velocity.limit(human.getMaxSpeed());
                human.healthStatus = 2;
                numInfected--;

                antibodies(human);
                human.antibodies--;

                recoveryTimeExpected(human);
            }
        }
    }

    /**
     * Create antibodies
     * @param human the person on the test
     */
    public static void antibodies(Human human) {
        human.antibodies = (int)Math.random()*10000;
    }

    /**
     * Determines the time needed for recovery
     * @param human the person on the test
     */
    public static void recoveryTimeExpected(Human human) {
        human.recoveryTime = Math.random()*(7000 - 5000 + 1) + 5000;
    }
}
