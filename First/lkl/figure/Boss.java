package figure;

import java.util.Random;

public class Boss extends Characters {
    private String name;

    public Boss(String name, int hp, int attack, int defense, int velocity) {
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
                name="霸王龙";
                break;
            case 1:
                name="翼龙";
                break;
            case 2:
                name="三角龙";
                break;
            case 3:
                name="冰霜巨龙";
                break;
            default:
                break;
        }
    }
}
