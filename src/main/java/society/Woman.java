package society;

import java.awt.*;

import static main.Screen.WIN_HEIGHT;
import static main.Screen.WIN_WIDTH;

/**
 * Woman class is subclass of Human and defines an object perceived as a female
 * @author Lukasz Michalski
 */
public class Woman extends Human{

    /**
     * Default constructor
     */
    public Woman(){
        super();
    }

    /**
     * Method draws the recognition symbol of a class instance
     * @param graphics see <a href="https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html">Class Graphics</a>
     */
    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(Color.CYAN);

        position.add(velocity);


        graphics.fillOval((int)position.x, (int)position.y, 7, 7);
    }
}
