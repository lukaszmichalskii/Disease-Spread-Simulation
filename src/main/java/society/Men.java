package society;

import java.awt.*;

import static gui.Panel.map;

/**
 * Men class is subclass of Human and defines an object perceived as a male
 * @author Lukasz Michalski
 */
public class Men extends Human{

    /**
     * Default constructor
     */
    public Men(){
        super();
    }

    /**
     * Method draws the recognition symbol of a class instance
     * @param graphics see <a href="https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html">Class Graphics</a>
     */
    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        graphics.fillOval((int) map.getPosition(this).x, (int) map.getPosition(this).y, 10, 10);
//        graphics.fillOval((int)position.x, (int)position.y, 10, 10);
    }
}
