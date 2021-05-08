package main;

import society.Human;
import society.Logic;
import society.Men;
import society.Woman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static society.Human.numInfected;

/**
 * The Panel class is responsible for background of simulation.
 * Responsible for render objects on map, their movement, behavior etc.
 * @author Lukasz Michalski
 */
public class Panel extends JPanel implements ActionListener {

    public static final int POPULATION = 200;
    public static int changeInPopulation = POPULATION;
    public static ArrayList<Human> people = new ArrayList<>();
    private Timer timer;

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

        timer = new Timer(12, this);
        timer.start();
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

        for (int i = 0; i < people.size(); i++)
            for (int j = i+1; j < people.size(); j++)
                Logic.collision(people.get(j), people.get(i));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        if (numInfected <= 0)
            timer.stop();
    }
}
