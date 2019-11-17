import equipment.Package;
import role.Boss;
import role.NormalEnemy;

public class Round {
    private String name;
    private NormalEnemy normalEnemy;
    private Boss boss;

    private Round(String name, NormalEnemy normalEnemy, Boss boss) {
        this.name = name;
        this.normalEnemy = normalEnemy;
        this.boss = boss;
    }

    public static Round build(int flag, Package pack){
        Boss boss=null;
        NormalEnemy normalEnemy=NormalEnemy.build();
        String name=null;
        switch (flag) {
            case 1:
                boss=Boss.build(1);
                name="水帘洞";
                break;
            case 2:
                boss=Boss.build(2);
                name="盘丝洞";
                break;
            case 3:
                boss=Boss.build(3);
                name="火焰山";
                break;
            case 4:
                boss=Boss.build(4);
                name="袁子山";
                break;
            case 5:
                boss=Boss.build(5);
                name="尼泊尔湖";
                break;
            case 6:
                boss=Boss.build(6);
                name="喜马拉雅山";
                break;
            case 7:
                boss=Boss.build(7);
                name="真新镇";
                break;
            case 8:
                boss=Boss.build(8);
                name="炼狱镇";
                break;
            case 9:
                boss=Boss.build(9);
                name="哥布林王国";
                break;
            case 10:
                boss=Boss.build(10);
                name="终焉之地";
                break;
            default:
                break;
        }
        assert boss != null;
        boss.registerObserver(pack);
        return new Round(name,normalEnemy,boss);
    }


    public NormalEnemy getNormalEnemy() {
        return normalEnemy;
    }

    public Boss getBoss() {
        return boss;
    }

    public String getName() {
        return name;
    }
}
