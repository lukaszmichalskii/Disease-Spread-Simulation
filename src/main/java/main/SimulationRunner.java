package main;

import gui.MenuScreen;
import gui.Screen;

import java.awt.event.ActionEvent;

/**
 * Class responsible for run simulation
 * @author Lukasz Michalski
 */
public class SimulationRunner extends MenuScreen {

    /**
     * Main method of simulation
     * @param args basic main function arguments
     */
    public static void main(String[] args) {
        SimulationRunner runner = new SimulationRunner();
        //Screen screen = new Screen();
    }

    /**
     * Method determines what runs when the start button is pressed
     * @param e see <a href="https://docs.oracle.com/javase/7/docs/api/java/awt/event/ActionEvent.html">Class Graphics</a>
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startBtn) {
            frame.dispose();
            Screen screen = new Screen();
        }
    }
}
