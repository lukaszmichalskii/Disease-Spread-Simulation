package tools;

import society.Human;

import java.util.ArrayList;
import java.util.HashMap;

import static gui.Panel.people;
import static gui.Screen.WIN_HEIGHT;
import static gui.Screen.WIN_WIDTH;
import static society.Logic.maxSpeed;

public class Map {

    private java.util.Map<Human, java.util.Map<String, Vector>> map;


    public Map(int SIZE) {
        ArrayList<java.util.Map<String, Vector>> movement = attributesCreator(SIZE);
        map = mapCreator(movement);
    }

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

    public Vector getPosition(Human human) {
        return map.get(human).get("position");
    }

    public void setPosition(Human human, Vector position) {
        map.get(human).put("position", position);
    }

    public Vector getVelocity(Human human) {
        return map.get(human).get("velocity");
    }

    public void setVelocity(Human human, Vector velocity) {
        map.get(human).put("velocity", velocity);
    }

    public Vector getAcceleration(Human human) {
        return map.get(human).get("acceleration");
    }

    public void setAcceleration(Human human, Vector acceleration) {
        map.get(human).put("acceleration", acceleration);
    }
}
