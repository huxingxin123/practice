package figure;

import java.util.Random;

public class WildMonster extends Characters {
    private String name;

    public WildMonster(String name, int hp, int attack, int defense, int velocity) {
        super(name, hp, attack, defense, velocity);
        this.name=name;
    }

    @Override
    public String getName() {
        set();
        return name;
    }


    //每次在获取名字时随机设置一个
    private void set(){
        Random random=new Random();
        int a=random.nextInt(5);
        switch (a){
            case 0:
                name="远古石像";
                break;
            case 1:
                name="河蟹";
                break;
            case 2:
                name="红岩小怪";
                break;
            case 3:
                name="幽灵护卫";
                break;
            default:
                break;
        }
    }
}


