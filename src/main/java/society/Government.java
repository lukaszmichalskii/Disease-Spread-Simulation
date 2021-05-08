package society;

import static society.Doctor.numDead;
import static society.Doctor.numInfected;

/**
 * Government responsible for make analysis and make decisions for disease control
 * @author Lukasz Michalski
 */
public class Government {

    public static int POPULATION = 200;

    /**
     * Method introduce restrictions to whole society.
     * @param human
     */
    public static void introduceRestrictions(Human human) {
        if (isDangerous()) {
            Logic.distanceYourself(human);
            Logic.update(human);
        }
    }

    /**
     * isDangerous method decide when restrictions is necessary.
     * @return
     */
    private static boolean isDangerous() {
        return numInfected >= 0.7 * (POPULATION - numDead) || numDead >= 0.3 * (POPULATION - numDead);
    }
}
