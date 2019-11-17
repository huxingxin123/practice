import java.util.Random;

class Boss extends Character {
    private String name;

     Boss(int hp, int attack, int defense, int velocity) {
        super(hp, attack, defense, velocity);
    }

     @Override
     public String getName() {
         set();
         return name;
     }

     @Override
     public void setName(String name) {
         this.name = name;
     }

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
                name="刘坤龙";
                break;
            default:
                break;
        }
    }
 }