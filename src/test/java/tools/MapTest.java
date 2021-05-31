package tools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;


public class MapTest {

    @Test
    public void attributesCreatorTest() {
        try {
            // access to private method
            Method attributesCreator = Map.class.getDeclaredMethod("attributesCreator", int.class);
            attributesCreator.setAccessible(true);

            Map map = new Map();
            ArrayList<java.util.Map<String, Vector>> test = (ArrayList<java.util.Map<String, Vector>>) attributesCreator.invoke(map, -3);
            ArrayList<java.util.Map<String, Vector>> test2 = (ArrayList<java.util.Map<String, Vector>>) attributesCreator.invoke(map, 0);
            ArrayList<java.util.Map<String, Vector>> test3 = (ArrayList<java.util.Map<String, Vector>>) attributesCreator.invoke(map, 200);

            Assertions.assertNull(test, "attributesCreator test failed (negative argument was supplied)");
            Assertions.assertNull(test2, "attributesCreator test failed (create dataset of size 0)");
            Assertions.assertNotNull(test3, "attributesCreator test failed - return null object");
            for (java.util.Map<String, Vector> stringVectorMap : test3) {
                Assertions.assertNotNull(stringVectorMap.get("position"), "Position vector creation test failed");
                Assertions.assertNotNull(stringVectorMap.get("acceleration"), "Acceleration vector creation test failed");
                Assertions.assertNotNull(stringVectorMap.get("velocity"), "Velocity vector creation test failed");
            }
        } catch (Exception e) {
            Assertions.fail("attributesCreator test failed");
        }

    }
}
