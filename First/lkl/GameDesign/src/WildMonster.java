import java.util.Random;

class WildMonster extends Character {

     private String name;

     @Override
     public String getName() {
         set();
         return name;
     }

     @Override
     public void setName(String name) {
         this.name = name;
     }

     WildMonster(int hp, int attack, int defense, int velocity) {
        super(hp, attack, defense, velocity);
    }

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


