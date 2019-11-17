package com.sdz.gameprops;

import com.sdz.gameprops.advanced.AdvancedAggressivenessProp;
import com.sdz.gameprops.advanced.AdvancedDefensivenessProp;
import com.sdz.gameprops.advanced.AdvancedLifeValueProp;
import com.sdz.gameprops.advanced.AdvancedSpeedProp;
import com.sdz.gameprops.ordinary.*;

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
