package gui;

import disease.DiseaseSpreader;
import society.*;
import tools.Vector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static gui.Screen.WIN_HEIGHT;
import static gui.Screen.FRAME_WIDTH;
import static society.Doctor.numDead;
import static society.Doctor.numInfected;
import static society.Government.POPULATION;

/**
 * The Panel class is responsible for background of simulation.
 * Responsible for render objects on map, their movement, behavior etc.
 * @author Lukasz Michalski
 */
public class Panel extends JPanel implements ActionListener {

    public static ArrayList<Human> people = new ArrayList<>();
    private ArrayList<tools.Vector> infectionsChart = new ArrayList<>();
    private ArrayList<tools.Vector> deathsChart = new ArrayList<>();

    private Timer timer;
    private int delay = 12;
    private int time = 0;

    /**
     * Default constructor.
     */
    public Panel() {
        this.setBackground(Color.LIGHT_GRAY);

        for(int i = 0; i < POPULATION; i++) {
            if (i < (int)(0.5 * POPULATION))
                people.add(new Men());
            else
                people.add(new Woman());
        }

        timer = new Timer(delay, this);
        timer.start();
    }

    /**
     * Method responsible for render whole population on map
     * @param graphics see <a href="https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html">Class Graphics</a>
     */
    public void paint(Graphics graphics) {
        super.paintComponent(graphics);

        infectionsChart.add(new tools.Vector((double) time/delay, numInfected));
        deathsChart.add(new tools.Vector(time/delay, numDead));
        time += 10;


        for (Human human: people) {
            human.paint(graphics);
            Doctor.diagnose(human);
            Police.control(human);

            if (human.getResistance() <= 1) {
                Logic.distanceYourself(human);
                Logic.update(human);
            }

            // only when the disease becomes dangerous
            Government.introduceRestrictions(human);
        }

        for (int i = 0; i < people.size(); i++)
            for (int j = i+1; j < people.size(); j++)
                DiseaseSpreader.collision(people.get(j), people.get(i));

        // infections chart
        graphics.setColor(Color.RED);
        for (tools.Vector infectionPoint: infectionsChart) {
            graphics.fillRect((int) infectionPoint.x, (WIN_HEIGHT - FRAME_WIDTH) - (int) infectionPoint.y, 2, 2);
        }

        // deaths chart
        graphics.setColor(Color.black);
        for (tools.Vector deathsPoint: deathsChart) {
                graphics.fillRect((int) deathsPoint.x, (WIN_HEIGHT - FRAME_WIDTH) - (int) deathsPoint.y, 2, 2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        if (numInfected <= 0)
            timer.stop();
    }
}
