package com.sdz.utils;

import com.sdz.game.Protagonist;
import com.sdz.gameprops.Bag;
import com.sdz.gameprops.Prop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Order {
    String order;
    public Order() {

    }

    public boolean inputGoOn(Protagonist player) {
        System.out.printf("\n\t按enter:继续前进\n\t输入1查看主角的血量状态\n请输入:");
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String str = bf.readLine().toString();
            if(str.length()==0){
                System.out.println("进入下一波野怪");
            }
            if("1".equals(str)){
                System.out.printf("%s的剩余生命值为%d\n",player.getName(),player.getLifeValue());
                inputGoOn(player);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }



    public boolean inputUseProp(Protagonist player) {
        System.out.printf("是否使用道具补给:\n\t按enter继续;\n\t输入1使用道具;\n: ");
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String str = bf.readLine().toString();
            if (str.length() == 0) {
                return false;
            }
            if ("1".equals(str)) {
                Bag bag = player.getBag();
                int typeNumber [] = bag.getTypeNumber();

                ArrayList<Prop> propList = bag.getPropList();
                int preparedUse [] = new int[8];
                //显示背包
                bag.showBag();
                System.out.println("请输入要使用药剂的数量如: 1 2 3 4 5 6 7 8");
                Scanner scanner = new Scanner(System.in);
                //输入并检查药剂使用数量
                for (int i = 0; i < preparedUse.length; i++) {
                    preparedUse[i] = scanner.nextInt();
                    if (preparedUse[i] > typeNumber[i]) {
                        System.out.println("输入有误");
                        inputUseProp(player);
                        return false;
                    }
                }

                //使用药剂
                for (int i=0;bag.getPropList().size()>0;i++) {//判断背包是否为空
                    //使用正则表达式判断输入数组是否全部为0
                    if((Arrays.toString(preparedUse)).matches("^\\[(0,\\s)*0\\]$")){
                        break;
                    }
                    Prop prop = propList.get(i);

                    switch (prop.getType()) {
                        case 0:{
                            if (prop.getLevel() == 1 && preparedUse[0] >= 1) {
                                prop.beUsedBy(player);
                                preparedUse[0]--;
                                typeNumber[0]--;
                                propList.remove(i);
                                i--;
                            } else if (prop.getLevel() == 2 && preparedUse[4] >= 1) {
                                prop.beUsedBy(player);
                                preparedUse[4]--;
                                typeNumber[4]--;
                                propList.remove(i);
                                i--;
                            }
                            break;
                        }
                        case 1:{
                            if (prop.getLevel() == 1 && preparedUse[1] >= 1) {
                                prop.beUsedBy(player);
                                preparedUse[1]--;
                                typeNumber[1]--;
                                propList.remove(i);
                                i--;
                            } else if (prop.getLevel() == 2 && preparedUse[5] >= 1) {
                                prop.beUsedBy(player);
                                preparedUse[5]--;
                                typeNumber[5]--;
                                propList.remove(i);
                                i--;
                            }
                            break;
                        }
                        case 2:{
                            if (prop.getLevel() == 1 && preparedUse[2] >= 1) {
                                prop.beUsedBy(player);
                                preparedUse[2]--;
                                typeNumber[2]--;
                                propList.remove(i);
                                i--;
                            } else if (prop.getLevel() == 2 && preparedUse[6] >= 1) {
                                prop.beUsedBy(player);
                                preparedUse[6]--;
                                typeNumber[6]--;
                                propList.remove(i);
                                i--;
                            }
                            break;
                        }
                        case 3:{
                            if (prop.getLevel() == 1 && preparedUse[3] >= 1) {
                                prop.beUsedBy(player);
                                preparedUse[3]--;
                                typeNumber[3]--;
                                propList.remove(i);
                                i--;
                            } else if (prop.getLevel() == 2 && preparedUse[7] >= 1) {
                                prop.beUsedBy(player);
                                preparedUse[7]--;
                                typeNumber[7]--;
                                propList.remove(i);
                                i--;
                            }
                            break;
                        }
                    }
                }
                System.out.println("剩余药剂情况:");
                bag.showBag();

//                for (int i = 0; i < bag.size(); ) {
////                    bag.get(0).beUsedBy(player);
////                    bag.remove(0);
////                }

//                for (Prop prop : bag) {
//                    prop.beUsedBy(player);
//                }
//
//                for (Iterator<Prop> prop = bag.iterator(); prop.hasNext();) {
//                    prop.remove();
//                }

            }else{
                System.out.println("请输入正确的指令");
                inputUseProp(player);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        return true;
    }
}
