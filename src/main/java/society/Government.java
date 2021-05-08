package society;

import static main.Panel.changeInPopulation;
import static society.Human.numInfected;

public class Government {

    public static void introduceRestrictions(Human human) {
        if (numInfected > 0.4 * changeInPopulation) {
            Logic.distanceYourself(human);
            Logic.update(human);
        }
    }
}
