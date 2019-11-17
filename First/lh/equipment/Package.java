package equipment;

import observe.Observer;

import java.util.ArrayList;

public class Package implements Observer {
    private ArrayList<Equipment> equipments;

    public Package() {
        equipments=new ArrayList<>();
    }


    @Override
    public void stop() {

    }

    @Override
    public void add(Equipment equipment) {
        equipments.add(equipment);
    }

    public ArrayList<Equipment> getEquipments() {
        return equipments;
    }
}
