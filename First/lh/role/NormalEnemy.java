package role;

import equipment.Equipment;

public class NormalEnemy extends Enemy {
    @Override
    public void attack(Role role) {
        Equipment equipment=role.getEquipment();
        int ATk=getATK();
        if (ATk<=role.getDefensivePower()+equipment.getDefensivePower()){
            System.out.println(role.getName()+"受到伤害为0");
            role.attack(this);
        }else {
            int damage=ATk-role.getDefensivePower()-equipment.getDefensivePower();
            int health=role.getHealthPoint()+equipment.getHealthPoint();
            if (damage>=health){
                System.out.println(role.getName()+"受到"+damage+"点伤害");
                role.setHealthPoint(0);
                System.out.println("你被击败了");
                role.notifyObserver();
            }else {
                role.setHealthPoint(health-damage);
                System.out.println(role.getName()+"受到"+damage+"点伤害，");
                role.attack(this);
            }
        }
    }


    private NormalEnemy(String name, int healthPoint, int ATK, int defensivePower, int agility) {
        super(name, healthPoint, ATK, defensivePower, agility);
    }

    public static NormalEnemy build() {
        return new NormalEnemy("普通小怪", 300000, 200000, 200000, 40);
    }

}
