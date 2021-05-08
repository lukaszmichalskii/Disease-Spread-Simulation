package society;

import static gui.Screen.WIN_HEIGHT;
import static gui.Screen.WIN_WIDTH;

/**
 * Class Police responsible for controlling society to stay in designated area
 * @author Lukasz Michalski
 */
public class Police {

    /**
     * Method responsible for controlling whether objects do not go beyond the designated area
     */
    public void control(Human human) {
            if (checkX(human))
                human.velocity.x *= -1;

            if (checkY(human))
                human.velocity.y *= -1;
    }

    /**
     * Method check if horizontal coordinate of object position is in designated area
     * @return statement of condition being in designated area (horizontal)
     */
    public boolean checkX(Human human) {
        return human.position.x < 0 || human.position.x > WIN_WIDTH;
    }

    /**
     * Method check if vertical coordinate of object position is in designated area
     * @return statement of condition being in designated area (vertical)
     */
    public boolean checkY(Human human) {
        return human.position.y < 0 || human.position.y > WIN_HEIGHT;
    }
}
