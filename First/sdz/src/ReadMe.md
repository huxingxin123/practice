### 文本游戏1.0
>大二第一次Android作业
#### 功能实现
1.实现对战系统
- 可以进行完整的单人作战

2.实现物品系统
- 打死野怪会随机掉落道具
**小野怪爆低级道具
打野怪爆高级道具**
- 闯过一关之后可以选择是否使用

3.实现技能
- 一定概率造成双倍伤害

#### 技术使用
1 单例模式 
    Game类
```
  public static synchronized Game GetDefaultGame(){
        if (game == null) {
            game = new Game();
        }
        return game;
    }
```
    
2 简单工厂模式
    Prop类
```
public class PropFactory {
    public PropFactory(){}

    public static Prop getProp(int propType,int level){

        Prop prop = null;

        switch (propType) {
            case PropEnum.LIFE_VALUE:
            {
                if(level==1){
                    prop = new OrdinaryLifeValueProp();
                }else if(level==2){
                    prop = new AdvancedLifeValueProp();
                }else{
                    System.out.println("等级错误");
                }
                break;
            }
            case PropEnum.AGGRESSIVENESS:
            {
                if(level==1) prop = new OrdinaryAggressivenessProp();
                else if(level ==2) prop = new AdvancedAggressivenessProp();
                else{
                    System.out.println("等级错误");
                }
                break;
            }
            case PropEnum.DEFENSIVE_POWER:
            {
                if(level==1) prop = new OrdinaryDefensivenessProp();
                else if(level==2) prop = new AdvancedDefensivenessProp();
                else{
                    System.out.println("等级错误");
                }
                break;
            }
            case PropEnum.SPEED:
            {
                if(level==1) prop = new OrdinarySpeedProp();
                else if(level==2) prop = new AdvancedSpeedProp();
                else{
                    System.out.println("等级错误");
                }
                break;
            }
        }
        return prop;
    }
}
```

    
3 多态,回调,正则


#### 问题解决
使用回调 
1. 怪物类和主角都实现onFight接口
2. 重写 beAttacked方法
3. 使用attack时触发回调,将beAttacked中的伤害值作为attack的返回值

#### 可扩展性
1. 多人对战 写一个MultipleFight类
2. 技能多样化 aoe,秒杀,吸血
3. 攻速使用多线程来实现无序性,和主角光环优先攻击
