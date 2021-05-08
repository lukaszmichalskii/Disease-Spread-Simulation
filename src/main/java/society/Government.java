package society;

import static society.Doctor.numDead;
import static society.Doctor.numInfected;

public class Government {

    public static void introduceRestrictions(Human human) {
        if (numInfected < numDead) {
            Logic.distanceYourself(human);
            Logic.update(human);
        }
    }
}
