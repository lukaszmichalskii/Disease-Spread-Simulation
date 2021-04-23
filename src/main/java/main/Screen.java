package main;

import javax.swing.*;

/**
 * The Screen class create the window of project, set GUI of app.
 * @author Lukasz Michalski
 */
public class Screen extends JFrame {
    public static final int WIN_WIDTH = 1280;
    public static final int WIN_HEIGHT = 720;

    /**
     * Default constructor
     */
    public Screen(){
        this.setSize(WIN_WIDTH, WIN_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("Disease Spread Simulation");

        Panel panel = new Panel();
        this.add(panel);
    }

    /**
     * Main method of simulation
     * @param args
     */
    public static void main(String[] args) {
        Screen screen = new Screen();
    }
}
