package tools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VectorTest {

    @Test
    public void constructorsTest() {
        Vector v1 = new Vector();
        Assertions.assertNotNull(v1, "Default constructor test failed");

        Vector v2 = new Vector(3.6,6.54);
        Assertions.assertNotNull(v2, "Constructor (parameters x,y) test failed");
    }

    @Test
    public void divRTest() {
        Vector v = new Vector(5,7);
        Vector v0 = v.divR(0);
        Vector v1 = v.divR(4);

        Assertions.assertNull(v0, "Division test failed - return null");
        Assertions.assertTrue(v1.x == 5.0/4 && v1.y == 7.0/4, "Division test failed");
    }

    @Test
    public void magnitudeTest() {
        Vector v = new Vector(4,5);
        double mag = v.magnitude();
        Assertions.assertTrue(mag == Math.sqrt(41));
    }

    @Test
    public void limitTest() {
        Vector v = new Vector(3,4);
        double limitation = 3.53;
        v.limit(limitation);
        Assertions.assertTrue(v.magnitude() <= limitation, "Limitation test failed");
    }
}
