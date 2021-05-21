package disease;

import society.Human;

import java.awt.*;

import static society.Doctor.numInfected;

/**
 * Disease Spreader define the way disease spreading and how dangerous the plague is.
 * @author Lukasz Michalski
 */
public class DiseaseSpreader {

    public static final int DISEASE_MORALITY_INDEX = 3;
    public static int SAFE_LEVEL_IMMUNITY = 8;
    public static double initial_numInfected = 0.08;

    /**
     * Defining the rules of the spread of plague
     * @param human1
     * @param human2
     */
    public static void collision(Human human1, Human human2) {
        Rectangle human1Radius = new Rectangle((int)human2.getPosition().x, (int)human2.getPosition().y, 10, 10);
        Rectangle human2Radius = new Rectangle((int)human1.getPosition().x, (int)human1.getPosition().y, 10, 10);

        if (human1Radius.intersects(human2Radius)) {
            if (human1.getHealthStatus() == 1 && (human2.getHealthStatus() == 0 || (human2.getHealthStatus() == 2 && human2.getAntibodies() <= 0))) {
                human2.setHealthStatus(1);
                numInfected++;
            }

            else if (human2.getHealthStatus() == 1 && (human1.getHealthStatus() == 0 || (human1.getHealthStatus() == 2 && human1.getAntibodies() <= 0))) {
                human1.setHealthStatus(1);
                numInfected++;
            }
        }
    }
}
