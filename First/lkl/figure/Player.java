package figure;

import java.util.ArrayList;

public class Player extends Characters {
    public ArrayList<String>arrayList=new ArrayList<>();

    public Player(String name, int hp, int attack, int defense, int velocity) {
        super(name, hp, attack, defense, velocity);
    }

}

