package main;

import society.Human;
import society.Men;
import society.Woman;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The Panel class is responsible for background of simulation.
 * Responsible for render objects on map, their movement, behavior etc.
 * @author Lukasz Michalski
 */
public class Panel extends JPanel {

    public static final int POPULATION = 100;
    ArrayList<Human> people = new ArrayList<>();

    /**
     * Default constructor.
     */
    public Panel() {
        this.setBackground(Color.LIGHT_GRAY);

        for(int i = 0; i < POPULATION; i++) {
            if (i < (int)(0.5 * POPULATION))
                people.add(new Men());
            people.add(new Woman());
        }
    }

    /**
     * Method responsible for render whole population on map
     * @param graphics see <a href="https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html">Class Graphics</a>
     */
    public void paint(Graphics graphics) {
        super.paintComponent(graphics);
        for (Human human: people) {
            human.paint(graphics);
        }
    }
}
