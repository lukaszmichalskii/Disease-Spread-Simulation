package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static disease.DiseaseSpreader.DISEASE_MORTALITY_INDEX;
import static disease.DiseaseSpreader.initial_numInfected;
import static society.Government.POPULATION;
import static society.Government.peoplePayAttention;

/**
 * Class in which you create the start screen GUI
 * @author Lukasz Michalski
 */
public abstract class MenuScreen extends JPanel implements ActionListener {
    protected JFrame frame = new JFrame("Launching Page");
    protected JButton startBtn = new JButton("Start");
    public static JCheckBox chartsOption = new JCheckBox("Charts");
    public static JCheckBox socialDistancingOption = new JCheckBox("Government restrictions");

    /**
     * Default constructor
     */
    public MenuScreen() {
        JSlider setPopulation = new JSlider(10,500,300);
        JSlider setDiseaseMortality = new JSlider(0, 10, 3);
        JSlider setInitialInfections = new JSlider(0 , 100, 8);
        JSlider setPeoplePayAttention = new JSlider(0 , 100, 4);
        JLabel textPopulation = new JLabel();
        JLabel textDiseaseMortality = new JLabel();
        JLabel textInitialInfections = new JLabel();
        JLabel textPeoplePayAttention = new JLabel();


        startBtn.setFocusable(false);
        startBtn.addActionListener(this);

        setPopulation.setMajorTickSpacing(100);
        setPopulation.setPaintTicks(true);
        setPopulation.setMinorTickSpacing(10);
        textPopulation.setText("Population: " + setPopulation.getValue());
        POPULATION = setPopulation.getValue();

        setDiseaseMortality.setMajorTickSpacing(5);
        setDiseaseMortality.setPaintTicks(true);
        setDiseaseMortality.setMinorTickSpacing(10);
        textDiseaseMortality.setText("Disease morality: " + setDiseaseMortality.getValue());
        DISEASE_MORTALITY_INDEX = setDiseaseMortality.getValue();

        setInitialInfections.setMajorTickSpacing(100);
        setInitialInfections.setPaintTicks(true);
        setInitialInfections.setMinorTickSpacing(10);
        textInitialInfections.setText("Initial infections: " + setInitialInfections.getValue() + "%");
        initial_numInfected = (double) setInitialInfections.getValue()/100;

        setPeoplePayAttention.setMajorTickSpacing(100);
        setPeoplePayAttention.setPaintTicks(true);
        setPeoplePayAttention.setMinorTickSpacing(10);
        textPeoplePayAttention.setText("People social distance on their own: " + setPeoplePayAttention.getValue() + "%");
        peoplePayAttention = (double) setPeoplePayAttention.getValue()/100;

        startBtn.setBounds(30,40,100,40);
        setPopulation.setBounds(30,100,300,38);
        textPopulation.setBounds(35,140,300,30);
        setDiseaseMortality.setBounds(30, 180, 300, 38);
        textDiseaseMortality.setBounds(35, 220, 300, 30);
        setInitialInfections.setBounds(30,270,300,38);
        textInitialInfections.setBounds(35,300,300,30);
        setPeoplePayAttention.setBounds(30,350,300,38);
        textPeoplePayAttention.setBounds(35,380,400,30);
        chartsOption.setBounds( 150,40,100,20);
        socialDistancingOption.setBounds( 150,60,250,20);


        setPopulation.addChangeListener(e -> {
            textPopulation.setText("Population: " + setPopulation.getValue());
            POPULATION = setPopulation.getValue();
        });

        setDiseaseMortality.addChangeListener(e -> {
            textDiseaseMortality.setText("Disease morality: " + setDiseaseMortality.getValue());
            DISEASE_MORTALITY_INDEX = setDiseaseMortality.getValue();
        });

        setInitialInfections.addChangeListener(e -> {
            textInitialInfections.setText("Initial infections: " + setInitialInfections.getValue() + "%");
            initial_numInfected = (double) setInitialInfections.getValue()/100;
        });

        setPeoplePayAttention.addChangeListener(e -> {
            textPeoplePayAttention.setText("People social distance on their own: " + setPeoplePayAttention.getValue() + "%");
            peoplePayAttention = (double) setPeoplePayAttention.getValue()/100;
        });

        chartsOption.setFocusable(false);
        socialDistancingOption.setFocusable(false);

        startBtn.setFont(new Font("Consolas", Font.PLAIN, 15));
        setInitialInfections.setFont(new Font("Consolas", Font.PLAIN, 15));
        textPopulation.setFont(new Font("Consolas", Font.PLAIN, 15));
        setDiseaseMortality.setFont(new Font("Consolas", Font.PLAIN, 15));
        textDiseaseMortality.setFont(new Font("Consolas", Font.PLAIN, 15));
        setInitialInfections.setFont(new Font("Consolas", Font.PLAIN, 15));
        textInitialInfections.setFont(new Font("Consolas", Font.PLAIN, 15));
        textPeoplePayAttention.setFont(new Font("Consolas", Font.PLAIN, 15));
        chartsOption.setFont(new Font("Consolas", Font.PLAIN, 15));
        socialDistancingOption.setFont(new Font("Consolas", Font.PLAIN, 15));

        frame.add(startBtn);
        frame.add(chartsOption);
        frame.add(socialDistancingOption);

        frame.add(setPopulation);
        frame.add(setDiseaseMortality);
        frame.add(setInitialInfections);
        frame.add(setPeoplePayAttention);

        frame.add(textPopulation);
        frame.add(textDiseaseMortality);
        frame.add(textInitialInfections);
        frame.add(textPeoplePayAttention);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,720);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    /**
     * Method determines what runs when the start button is pressed
     * @param e see <a href="https://docs.oracle.com/javase/7/docs/api/java/awt/event/ActionEvent.html">Class Graphics</a>
     */
    public abstract void actionPerformed(ActionEvent e);

}
