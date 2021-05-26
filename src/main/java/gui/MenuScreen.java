package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static disease.DiseaseSpreader.DISEASE_MORALITY_INDEX;
import static disease.DiseaseSpreader.initial_numInfected;
import static society.Government.POPULATION;

/**
 * Class in which you create the start screen GUI
 * @author Lukasz Michalski
 */
public abstract class MenuScreen extends JPanel implements ActionListener {
    protected JFrame frame = new JFrame("Launching Page");
    protected JButton startBtn = new JButton("Start");

    /**
     * Default constructor
     */
    public MenuScreen() {
        JSlider setPopulation = new JSlider(0,300,100);
        JSlider setDiseaseMorality = new JSlider(0, 10, 3);
        JSlider setInitialInfections = new JSlider(0 , 100, 8);
        JLabel textPopulation = new JLabel();
        JLabel textDiseaseMorality = new JLabel();
        JLabel textInInitialInfections = new JLabel();

        startBtn.setFocusable(false);
        startBtn.addActionListener(this);

        setPopulation.setMajorTickSpacing(100);
        setPopulation.setPaintTicks(true);
        setPopulation.setMinorTickSpacing(10);
        textPopulation.setText("Population: " + setPopulation.getValue());
        POPULATION = setPopulation.getValue();

        setDiseaseMorality.setMajorTickSpacing(5);
        setDiseaseMorality.setPaintTicks(true);
        setDiseaseMorality.setMinorTickSpacing(10);
        textDiseaseMorality.setText("Disease morality: " + setDiseaseMorality.getValue());
        DISEASE_MORALITY_INDEX = setDiseaseMorality.getValue();

        setInitialInfections.setMajorTickSpacing(100);
        setInitialInfections.setPaintTicks(true);
        setInitialInfections.setMinorTickSpacing(10);
        textInInitialInfections.setText("Initial infections: " + setInitialInfections.getValue() + "%");
        initial_numInfected = (double) setInitialInfections.getValue()/100;

        startBtn.setBounds(160,40,100,40);
        setPopulation.setBounds(60,120,300,40);
        textPopulation.setBounds(160,150,100,30);
        setDiseaseMorality.setBounds(60, 200, 300, 40);
        textDiseaseMorality.setBounds(160, 230, 150, 30);
        setInitialInfections.setBounds(60,280,300,40);
        textInInitialInfections.setBounds(160,310,150,30);

        setPopulation.addChangeListener(e -> {
            textPopulation.setText("Population: " + setPopulation.getValue());
            POPULATION = setPopulation.getValue();
        });

        setDiseaseMorality.addChangeListener(e -> {
            textDiseaseMorality.setText("Disease morality: " + setDiseaseMorality.getValue());
            DISEASE_MORALITY_INDEX = setDiseaseMorality.getValue();
        });

        setInitialInfections.addChangeListener(e -> {
            textInInitialInfections.setText("Initial infections: " + setInitialInfections.getValue() + "%");
            initial_numInfected = (double) setInitialInfections.getValue()/100;
        });

        frame.add(startBtn);
        frame.add(setPopulation);
        frame.add(setDiseaseMorality);
        frame.add(setInitialInfections);

        frame.add(textPopulation);
        frame.add(textDiseaseMorality);
        frame.add(textInInitialInfections);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    /**
     * Method determines what runs when the start button is pressed
     * @param e see <a href="https://docs.oracle.com/javase/7/docs/api/java/awt/event/ActionEvent.html">Class Graphics</a>
     */
    @Override
    public abstract void actionPerformed(ActionEvent e);
}
