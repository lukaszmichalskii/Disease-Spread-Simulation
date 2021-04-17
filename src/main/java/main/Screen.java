package main;

import javax.swing.*;

public class Screen extends JFrame {
    private final int WIN_WIDTH = 1280;
    private final int WIN_HEIGHT = 720;

    public Screen(){
        this.setSize(WIN_WIDTH, WIN_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("Disease Spread Simulation");

        Panel panel = new Panel();
        this.add(panel);
    }

    public static void main(String[] args) {
        Screen screen = new Screen();
    }
}
