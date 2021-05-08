package society;

import static society.Doctor.numDead;
import static society.Doctor.numInfected;

public class Government {

    public static int POPULATION = 200;

    public static void introduceRestrictions(Human human) {
        if (numInfected >= POPULATION - numDead || numDead >= 0.5 * POPULATION) {
            Logic.distanceYourself(human);
            Logic.update(human);
        }
    }
}
