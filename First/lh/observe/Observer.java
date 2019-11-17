package observe;

import equipment.Equipment;

public interface Observer {
    public void stop();
    public void add(Equipment equipment);
}
