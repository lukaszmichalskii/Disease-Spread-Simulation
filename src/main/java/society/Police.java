package society;

import static gui.Screen.WIN_HEIGHT;
import static gui.Screen.WIN_WIDTH;
import static gui.Panel.map;

/**
 * Class Police responsible for controlling society to stay in designated area
 * @author Lukasz Michalski
 */
public class Police {

    /**
     * Method responsible for controlling whether objects do not go beyond the designated area
     */
    public static void control(Human human) {
            if (checkX(human))
                map.getVelocity(human).x *= -1;
//                human.velocity.x *= -1;

            if (checkY(human))
                map.getVelocity(human).y *= -1;
//                human.velocity.y *= -1;
    }

    /**
     * Method check if horizontal coordinate of object position is in designated area
     * @return statement of condition being in designated area (horizontal)
     */
    public static boolean checkX(Human human) {
        return map.getPosition(human).x < 0 || map.getPosition(human).x > WIN_WIDTH;
//        return human.position.x < 0 || human.position.x > WIN_WIDTH;
    }

    /**
     * Method check if vertical coordinate of object position is in designated area
     * @return statement of condition being in designated area (vertical)
     */
    public static boolean checkY(Human human) {
        return map.getPosition(human).y < 0 || map.getPosition(human).y > WIN_HEIGHT;
//        return human.position.y < 0 || human.position.y > WIN_HEIGHT;
    }
}
