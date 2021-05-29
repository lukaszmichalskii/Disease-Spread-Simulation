package society;

import static disease.DiseaseSpreader.*;
import static society.Logic.maxSpeed;
import static gui.Panel.map;

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
        if (human.getHealthStatus() == 1 && (human.getResistance() <= DISEASE_MORTALITY_INDEX || human.numSick >= 3)){
            human.recoveryTime -= fastTimeDelta;
            if (human.recoveryTime <= 0) {
                map.setVelocity(human, map.getVelocity(human).resetR());
                human.healthStatus = 3;
                numInfected--;

                numDead++;
            }
        }

        // conditions for really strong people
        else if (human.getHealthStatus() == 1 && human.getResistance() >= SAFE_LEVEL_IMMUNITY){
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
        else if (human.getHealthStatus() == 1 && human.getResistance() < SAFE_LEVEL_IMMUNITY && human.getResistance() > DISEASE_MORTALITY_INDEX){
            map.setVelocity(human, map.getVelocity(human).divR(1.001));
            human.recoveryTime -= normalTimeDelta;
            if (human.recoveryTime <= 0){
                map.setVelocity(human, map.getVelocity(human).multR(3));
                map.setVelocity(human, map.getVelocity(human).limitR(maxSpeed));
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
        human.antibodies = Math.random();
    }

    /**
     * Determines the time needed for recovery
     * @param human the person on the test
     */
    public static void recoveryTimeExpected(Human human) {
        human.recoveryTime = Math.random()*(7000 - 5000 + 1) + 5000;
    }
}
