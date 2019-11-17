public class Character {
    /**
     * 姓名，攻击力，防御等属性应该是玩家或者野怪共有的，在游戏开始之前就要设置好
     * @return
     */
    private String name;
    private int hp;
    private int attack;
    private int defense;
    private int velocity;
     Character(int hp, int attack, int defense, int velocity){
        this.hp=hp;
        this.attack=attack;
        this.defense=defense;
        this.velocity=velocity;
    }
    @Override
    public String toString() {
        return "代号:"+name+" "+"生命值:"+hp+" "+
                "攻击力:"+attack+" "+"防御力:"+defense+" "
                +"敏捷度:"+velocity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

     int getHp() {
        return hp;
    }

     void setHp(int hp) {
        this.hp = hp;
    }

     int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

     int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

     int getVelocity() {
        return velocity;
    }

}
