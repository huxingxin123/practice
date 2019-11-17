public class Player extends Character {

    private Equipment equipment;
    private int skill;

    //人物技能
    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    Player(String name, int hp, int attack, int defense, int velocity, int gameLevel) {
        super(hp, attack, defense, velocity);
        this.name=name;
        this.gameLevel=gameLevel;

        //装备栏和人物创建是绑定的
        equipment=new Equipment();
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private int gameLevel;




    public String toString() {
        return "姓名:"+name+super.toString()+"游戏难度:"+gameLevel;
    }
}
