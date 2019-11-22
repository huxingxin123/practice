package gameset;

import figure.Player;

public class Progress {
    private Player player;
    public Progress(Player player){
        this.player=player;
    }
    public void progress(int i) {
            System.out.println("***   欢迎来到第" + (i+1) + "关   ***");
            switch (i) {
                case 0:
                    System.out.println(player.getName()+"进入水帘洞");
                    break;
                case 1:
                    System.out.println(player.getName()+"进入凌霄宝殿");
                    break;
                case 2:
                    System.out.println(player.getName()+"进入南天门");
                    break;
                case 3:
                    System.out.println(player.getName()+"进入深海龙宫");
                    break;
                case 4:
                    System.out.println(player.getName()+"进入火焰山");
                    break;
                case 5:
                    System.out.println(player.getName()+"进入阴曹地府");
                    break;
                case 6:
                    System.out.println(player.getName()+"进入妖魔大道");
                    break;
                case 7:
                    System.out.println(player.getName()+"进入莲花圣池");
                    break;
                case 8:
                    System.out.println(player.getName()+"进入花果山");
                    break;
                case 9:
                    System.out.println(player.getName()+"进入重庆邮电大学");
                    break;
            }
    }
}
