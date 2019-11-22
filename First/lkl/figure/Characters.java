package figure;

public class Characters {

    //名字
    private String name;
    //血量
    private int hp;
    //攻击力
    private int attack;
    //防御力
    private int defense;
    //敏捷度
    private int velocity;

    public Characters(String name, int hp, int attack, int defense, int velocity){
        this.name=name;
        this.hp=hp;
        this.attack=attack;
        this.defense=defense;
        this.velocity=velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    @Override
    public String toString() {
        return "名字:"+name+" "+"生命值:"+hp+" "+
                "攻击力:"+attack+" "+"防御力:"+defense+" "
                +"敏捷度:"+velocity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getVelocity() {
        return velocity;
    }

}

