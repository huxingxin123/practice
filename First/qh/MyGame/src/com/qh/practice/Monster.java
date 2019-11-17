package com.qh.practice;

public class Monster {
	 int id;//关卡号
	 String address;//怪物的洞府名字
	 String name;  //怪物的名称
     int  initialLifeValue; //怪物的初始生命值
     int aggressivity; //怪物的攻击力
      int defensivePower;//怪物的防御力
      int agile; //怪物的敏捷
	public Monster(int id) {
		super();
		this.id = id;
	}
      
      public void initialize() {
    	  switch(id) {
    	  case 1:
    		  name="小老鼠";
    		  initialLifeValue=1;
    		  aggressivity=1;
    		  defensivePower=1;
    		  agile=1;
    		  address="无底洞";
    		  break;
    	  case 2:
    		  name="小蝎子";
    		  initialLifeValue=2;
    		  aggressivity=2;
    		  defensivePower=2;
    		  agile=2;
    		  address="琵琶洞";
    		  break;
    	  case 3:
    		  name="小黑熊";
    		  initialLifeValue=4;
    		  aggressivity=4;
    		  defensivePower=4;
    		  agile=4;
    		  address="黑风洞";
    		  break;
    	  case 4:
    		  name="小蜘蛛";
    		  initialLifeValue=8;
    		  aggressivity=8;
    		  defensivePower=8;
    		  agile=8;
    		  address="盘丝洞";
    		  break;
    	  case 5:
    		  name="小狮子";
    		  initialLifeValue=16;
    		  aggressivity=16;
    		  defensivePower=16;
    		  agile=16;
    		  address="狮驼洞";
    		  break;
    	  case 6:
    		  name="小大象";
    		  initialLifeValue=32;
    		  aggressivity=32;
    		  defensivePower=32;
    		  agile=32;
    		  address="白象洞";
    		  break;
    	  case 7:
    		  name="小鲲鹏";
    		  initialLifeValue=64;
    		  aggressivity=64;
    		  defensivePower=64;
    		  agile=64;
    		  address="鲲鹏洞";
    		  break;
    	  case 8:
    		  name="小鹿精";
    		  initialLifeValue=128;
    		  aggressivity=128;
    		  defensivePower=128;
    		  agile=128;
    		  address="清华洞";
    		  break;
    	  case 9:
    		  name="小豹子";
    		  initialLifeValue=256;
    		  aggressivity=256;
    		  defensivePower=256;
    		  agile=256;
    		  address="连环洞";
    		  break;
    	  case 10:
    		  name="小犀牛";
    		  initialLifeValue=512;
    		  aggressivity=512;
    		  defensivePower=512;
    		  agile=512;
    		  address="玄英洞";
    		  break;
    		  case 11:
          		  name="白毛老鼠精";
          		  initialLifeValue=2;
          		  aggressivity=2;
          		  defensivePower=2;
          		  agile=2;
          		  address="无底洞";
          		  break;
          	  case 12:
          		  name="蝎子精";
          		  initialLifeValue=4;
          		  aggressivity=4;
          		  defensivePower=4;
          		  agile=4;
          		  address="琵琶洞";
          		  break;
          	  case 13:
          		  name="黑熊精";
          		  initialLifeValue=8;
          		  aggressivity=8;
          		  defensivePower=8;
          		  agile=8;
          		  address="黑风洞";
          		  break;
          	  case 14:
          		  name="蜘蛛精";
          		  initialLifeValue=16;
          		  aggressivity=16;
          		  defensivePower=16;
          		  agile=16;
          		  address="盘丝洞";
          		  break;
          	  case 15:
          		  name="青狮";
          		  initialLifeValue=32;
          		  aggressivity=32;
          		  defensivePower=32;
          		  agile=32;
          		  address="狮驼洞";
          		  break;
          	  case 16:
          		  name="白象";
          		  initialLifeValue=64;
          		  aggressivity=64;
          		  defensivePower=64;
          		  agile=64;
          		  address="白象洞";
          		  break;
          	  case 17:
          		  name="大鹏";
          		  initialLifeValue=128;
          		  aggressivity=128;
          		  defensivePower=128;
          		  agile=128;
          		  address="鲲鹏洞";
          		  break;
          	  case 18:
          		  name="鹿精";
          		  initialLifeValue=256;
          		  aggressivity=256;
          		  defensivePower=256;
          		  agile=256;
          		  address="清华洞";
          		  break;
          	  case 19:
          		  name="艾叶豹子精";
          		  initialLifeValue=512;
          		  aggressivity=512;
          		  defensivePower=512;
          		  agile=512;
          		  address="连环洞";
          		  break;
          	  case 20:
          		  name="犀牛精";
          		  initialLifeValue=1024;
          		  aggressivity=1024;
          		  defensivePower=1024;
          		  agile=1024;
          		  address="玄英洞";
          		  break;
          	 default:
   			  break;
    	  }
      }
}
