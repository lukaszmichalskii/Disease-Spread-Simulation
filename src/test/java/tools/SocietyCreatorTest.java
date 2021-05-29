package tools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import society.Human;

import java.util.ArrayList;

public class SocietyCreatorTest {

    @Test
    public void createSocietyTest() {
        SocietyCreator societyCreator = new SocietyCreator();
        ArrayList<Human> test = societyCreator.createSociety(5);
        ArrayList<Human> test2 = societyCreator.createSociety(-6);

        Assertions.assertEquals(5,test.size(), "Society creator test failed");
        Assertions.assertNull(test2, "Society creator return null failed");

        for (Human h: test) {
            Assertions.assertTrue(h instanceof Human, "Society creator test failed - create diffrent object");
        }
    }
}
