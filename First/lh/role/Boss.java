package role;

import equipment.Display;
import equipment.Equipment;
import equipment.weapon.*;
import observe.Observer;
import observe.Subject;

import java.util.ArrayList;

public class Boss extends Enemy implements Subject, Display {
    private Equipment equipment;
    private ArrayList<Observer> observers;

    @Override
    public void attack(Role role) {
        Equipment equipment = role.getEquipment();
        int ATk = getATK();
        if (ATk <= role.getDefensivePower() + equipment.getDefensivePower()) {
            System.out.println(role.getName() + "受到伤害为0");
            role.attack(this);
        } else {
            int damage = ATk - role.getDefensivePower() - equipment.getDefensivePower();
            int health = role.getHealthPoint() + equipment.getHealthPoint();
            if (damage >= health) {
                System.out.println(role.getName() + "受到" + damage + "点伤害");
                role.setHealthPoint(0);
                System.out.println("你被击败了");
                role.notifyObserver();
            } else {
                role.setHealthPoint(health - damage);
                System.out.println(role.getName() + "受到" + damage + "点伤害，");
                role.attack(this);
            }
        }
    }

    private Boss(String name, int healthPoint, int ATK, int defensivePower, int agility, Equipment equipment) {
        super(name, healthPoint, ATK, defensivePower, agility);
        this.equipment = equipment;
        observers = new ArrayList<>();
    }


    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public static Boss build(int flag) {
        Equipment equipment = null;
        switch (flag) {
            case 1:
                equipment = new One(0, 50000, 0, 5);
                break;
            case 2:
                equipment = new Two(50000, 0, 20000, 0);
                break;
            case 3:
                equipment = new Three(0, 0, 50000, 0);
                break;
            case 4:
                equipment = new Four(20000, 30000, 0, 0);
                break;
            case 5:
                equipment = new Five(20000, 0, 60000, 2);
                break;
            case 6:
                equipment = new Six(100000, 0, 20000, 0);
                break;
            case 7:
                equipment = new Seven(0, 100000, 0, 10);
                break;
            case 8:
                equipment = new Eight(0, 0, 0, 40);
                break;
            case 9:
                equipment = new Nine(0, 0, 300000, 0);
                break;
            case 10:
                equipment = new Ten(400000, 0, 0, 0);
                break;
            default:
                break;
        }
        return new Boss("Boss", 800000, 450000, 600000, 60, equipment);
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.add(equipment);
        }
    }

    public void lose() {
        notifyObserver();
        show();
    }


    @Override
    public void show() {

        int healthPoint = equipment.getHealthPoint();
        int ATK = equipment.getATK();
        int defensivePower = equipment.getDefensivePower();
        int agility = equipment.getAgility();
        System.out.println("装备属性：");
        System.out.println("生命值：" + healthPoint);
        System.out.println("攻击力：" + ATK);
        System.out.println("防御力：" + defensivePower);
        System.out.println("敏捷度：" + agility);
    }
}
