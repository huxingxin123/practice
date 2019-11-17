package role;


import equipment.Equipment;
import equipment.Package;
import exception.SetException;
import observe.Observer;
import observe.Subject;

import java.util.ArrayList;
import java.util.Random;


public class Role implements Subject {
    private String name;
    private int healthPoint;//生命值
    private int ATK;//攻击力
    private int defensivePower;//防御力
    private int agility;//敏捷度

    private Equipment equipment;
    private ArrayList<Observer> observers;

    public Equipment getEquipment() {
        return equipment;
    }

    public Role(String name, int healthPoint, int ATK, int defensivePower, int agility) {
        this.name = name;
        this.healthPoint = healthPoint;
        this.ATK = ATK;
        this.defensivePower = defensivePower;
        this.agility = agility;
        equipment = Equipment.build();
        observers=new ArrayList<>();
    }

    public void attack(Enemy enemy) {
        Random random=new Random();
        int rd=random.nextInt(100);
        int Atk=this.ATK;
        if (rd<=20){
            System.out.println("造成了暴击！");
            Atk=Atk*2;
        }
        if (Atk + this.equipment.getATK() <= enemy.getDefensivePower()) {
            System.out.println(enemy.getName() + "血量减少0点");
        } else {
            int damage = Atk + this.equipment.getATK() - enemy.getDefensivePower();
            System.out.println("造成" + damage + "点伤害");
            int health = enemy.getHealthPoint() - damage;
            if (health <= 0) {
                System.out.println(enemy.getName() + "死亡。");
                if (enemy instanceof Boss){
                    ((Boss) enemy).lose();
                }
            } else {
                enemy.setHealthPoint(health);
                System.out.println(enemy.getName() + "还剩余" + enemy.getHealthPoint() + "点血。");
                enemy.attack(this);
            }
        }

    }


    public String getName() {
        return name;
    }


    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        if (healthPoint>=0&&healthPoint<=999999){
            this.healthPoint = healthPoint;
        }else {
            try {
                throw new SetException("生命值不能超过999999以及低于1");
            } catch (SetException e) {
                e.printStackTrace();
            }
        }

    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        if (ATK>=0&&ATK<=999999){
            this.ATK = ATK;
        }else {
            try {
                throw new SetException("攻击力不能超过999999以及低于1");
            } catch (SetException e) {
                e.printStackTrace();
            }
        }
    }

    public int getDefensivePower() {
        return defensivePower;
    }

    public void setDefensivePower(int defensivePower) {
        if (defensivePower>=0&&defensivePower<=999999){
            this.defensivePower = defensivePower;
        }else {
            try {
                throw new SetException("防御力不能超过999999以及低于1");
            } catch (SetException e) {
                e.printStackTrace();
            }
        }
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        if (agility>=0&&agility<=100){
            this.agility = agility;
        }else {
            try {
                throw new SetException("敏捷度不能超过100以及低于1");
            } catch (SetException e) {
                e.printStackTrace();
            }
        }
    }

    public void change(Package pack, boolean ifchange) {
        int index = pack.getEquipments().size();
        Equipment equipment = pack.getEquipments().get(index - 1);
        if (ifchange = true) {
            wareEquipment(equipment);
        }
    }

    private void wareEquipment(Equipment equipment) {
        this.equipment = equipment;
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
        if (this.healthPoint==0){
            for (Observer observer : observers) {
                observer.stop();
            }
        }
    }

}
