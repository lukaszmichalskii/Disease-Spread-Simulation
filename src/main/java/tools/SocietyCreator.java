package tools;

import society.Human;
import society.Men;
import society.Woman;

import java.util.ArrayList;

/**
 * Class responsible for create society objects
 * @author Lukasz Michalski
 */
public class SocietyCreator {

    /**
     * Create array represents society
     * @param SIZE of population
     * @return list of humans
     */
    public ArrayList<Human> createSociety(int SIZE) {
        if (SIZE > 0) {
            ArrayList<Human> society = new ArrayList<>();
            for(int i = 0; i < SIZE; i++) {
                if (i < (int)(0.5 * SIZE))
                    society.add(new Men());
                else
                    society.add(new Woman());
            }

            return society;
        }

        return null;
    }
}
