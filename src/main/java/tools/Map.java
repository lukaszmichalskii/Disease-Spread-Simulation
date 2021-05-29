package tools;

import society.Human;

import java.util.ArrayList;
import java.util.HashMap;

import static gui.Panel.people;
import static gui.Screen.WIN_HEIGHT;
import static gui.Screen.WIN_WIDTH;
import static society.Logic.maxSpeed;

/**
 * Class create and stores position, velocity and acceleration of society objects.
 * @author Lukasz Michalski
 */
public class Map {

    private java.util.Map<Human, java.util.Map<String, Vector>> map;

    /**
     * Constructor
     * @param SIZE
     */
    public Map(int SIZE) {
        ArrayList<java.util.Map<String, Vector>> movement = attributesCreator(SIZE);
        map = mapCreator(movement);
    }

    /**
     * Create map of human movement attributes
     * @param attributesStack array of dictionaries with position, velocity and acceleration values
     * @return complete map / null
     */
    private java.util.Map<Human, java.util.Map<String, Vector>> mapCreator(ArrayList<java.util.Map<String, Vector>> attributesStack) {
        if (attributesStack != null) {
            map = new HashMap<>();
            for (int i = 0; i < attributesStack.size(); i++) {
                map.put(people.get(i), attributesStack.get(i));
            }

            return map;
        }

        return null;
    }

    /**
     * Create dictionaries, every store unique movement parameters of society objects
     * @param SIZE number of dictionaries (every human different movement values)
     * @return array of dictionaries / null
     */
    private ArrayList<java.util.Map<String, Vector>> attributesCreator(int SIZE) {
        if (SIZE > 0) {
            ArrayList<java.util.Map<String, Vector>> attributesStack = new ArrayList<>();
            for (int i = 0; i < SIZE; i++) {
                java.util.Map<String, Vector> attributes = new HashMap<>();
                attributes.put("position", new Vector(Math.random() * WIN_WIDTH, Math.random() * WIN_HEIGHT));
                attributes.put("velocity", new Vector(Math.random() * (maxSpeed) +- 2, Math.random() * (maxSpeed) +- 2));
                attributes.put("acceleration", new Vector());
                attributesStack.add(attributes);
            }

            return attributesStack;
        }

        return null;
    }

    /**
     * Method get position vector of human from map
     * @param human analyze object (key to dictionary)
     * @return position vector of object
     */
    public Vector getPosition(Human human) {
        return map.get(human).get("position");
    }

    /**
     * Method set new position to human and save in map
     * @param human analyze object (key to dictionary)
     * @param position new position vector to set
     */
    public void setPosition(Human human, Vector position) {
        map.get(human).put("position", position);
    }

    /**
     * Method get velocity vector of human from map
     * @param human analyze object (key to dictionary)
     * @return velocity vector of object
     */
    public Vector getVelocity(Human human) {
        return map.get(human).get("velocity");
    }

    /**
     * Method set new velocity to human and save in map
     * @param human analyze object (key to dictionary)
     * @param velocity new velocity vector to set
     */
    public void setVelocity(Human human, Vector velocity) {
        map.get(human).put("velocity", velocity);
    }

    /**
     * Method get acceleration vector of human from map
     * @param human analyze object (key to dictionary)
     * @return acceleration vector of object
     */
    public Vector getAcceleration(Human human) {
        return map.get(human).get("acceleration");
    }

    /**
     * Method set new acceleration to human and save in map
     * @param human analyze object (key to dictionary)
     * @param acceleration new acceleration vector to set
     */
    public void setAcceleration(Human human, Vector acceleration) {
        map.get(human).put("acceleration", acceleration);
    }
}
