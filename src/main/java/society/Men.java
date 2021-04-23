package society;

import java.awt.*;

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
        graphics.setColor(Color.BLUE);
        graphics.fillOval((int)position.x, (int)position.y, 7, 7);
    }
}
