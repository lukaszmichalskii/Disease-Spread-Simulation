package disease;

import society.Human;

import java.awt.*;

import static society.Doctor.numInfected;
import static gui.Panel.map;

/**
 * Disease Spreader define the way disease spreading and how dangerous the plague is.
 * @author Lukasz Michalski
 */
public class DiseaseSpreader {

    public static int DISEASE_MORTALITY_INDEX;
    public static int SAFE_LEVEL_IMMUNITY = 8;
    public static double initial_numInfected;

    /**
     * Defining the rules of the spread of plague
     * @param human1 first one participating in the meeting
     * @param human2 second one participating in the meeting
     */
    public static void collision(Human human1, Human human2) {

        Rectangle human1Radius = new Rectangle((int)map.getPosition(human2).x, (int)map.getPosition(human2).y, 10, 10);
        Rectangle human2Radius = new Rectangle((int)map.getPosition(human1).x, (int)map.getPosition(human1).y, 10, 10);

        if (human1Radius.intersects(human2Radius)) {
            if (human1.getHealthStatus() == 1 && (human2.getHealthStatus() == 0 || (human2.getHealthStatus() == 2 && human2.getAntibodies() <= 0))) {
                human2.setHealthStatus(1);
                numInfected++;
                human2.increaseNumSick();
            }

            else if (human2.getHealthStatus() == 1 && (human1.getHealthStatus() == 0 || (human1.getHealthStatus() == 2 && human1.getAntibodies() <= 0))) {
                human1.setHealthStatus(1);
                numInfected++;
                human1.increaseNumSick();
            }
        }
    }
}
