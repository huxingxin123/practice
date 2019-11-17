package com.sdz.gameprops;

import java.util.ArrayList;

public class Bag {
    ArrayList<Prop> propList;
    int typeNumber[] = {0,0,0,0,0,0,0,0};

    public int[] getTypeNumber() {
        return typeNumber;
    }

    public void setTypeNumber(int[] typeNumber) {
        this.typeNumber = typeNumber;
    }

    public ArrayList<Prop> getPropList() {
        return propList;
    }

    public void setPropList(ArrayList<Prop> propList) {
        this.propList = propList;
    }

    public Bag() {
        this.propList = new ArrayList<Prop>();
    }

    public int showBag() {
        System.out.printf("小生命药剂数量: %d\n",typeNumber[0]);
        System.out.printf("小攻击药剂数量: %d\n",typeNumber[1]);
        System.out.printf("小防御药剂数量: %d\n",typeNumber[2]);
        System.out.printf("小极速药剂数量: %d\n",typeNumber[3]);
        System.out.printf("大生命药剂数量: %d\n",typeNumber[4]);
        System.out.printf("大攻击药剂数量: %d\n",typeNumber[5]);
        System.out.printf("大防御药剂数量: %d\n",typeNumber[6]);
        System.out.printf("大极速药剂数量: %d\n",typeNumber[7]);


        return 0;
    }
}
