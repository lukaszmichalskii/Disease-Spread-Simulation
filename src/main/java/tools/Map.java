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

    public Map(){}

    /**
     * Constructor of map
     * @param SIZE of created map
     */
    public Map(int SIZE) {
        map = mapCreator(SIZE);
    }

    /**
     * Create map which stores society objects movement param (dictionaries, every store unique movement parameters of society objects)
     * @param SIZE of map (society)
     * @return full map
     */
    private java.util.Map<Human, java.util.Map<String, Vector>> mapCreator(int SIZE) {
        map = new HashMap<>();
        if (SIZE > 0) {
            ArrayList<java.util.Map<String, Vector>> attributesStack = new ArrayList<>();
            for (int i = 0; i < SIZE; i++) {
                java.util.Map<String, Vector> attributes = new HashMap<>();
                attributes.put("position", new Vector(Math.random() * WIN_WIDTH, Math.random() * WIN_HEIGHT));
                attributes.put("velocity", new Vector(Math.random() * (maxSpeed) +- 2, Math.random() * (maxSpeed) +- 2));
                attributes.put("acceleration", new Vector());
                attributesStack.add(attributes);
                map.put(people.get(i), attributesStack.get(i));
            }

            return map;
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
