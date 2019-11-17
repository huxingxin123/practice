package com.qh.practice;

import java.util.Scanner;

/**
 * 游戏设置
 * @author Administrator
 *
 */
public class GameSetting {
	 int gameDifficulty;//游戏难度
	LeadingRole leadingrole;
	Monster monster;

	int k1=0,k2=0,k3=0,k4=0,k5=0,k6=0,k7=0,k8=0,k9=0,k10=0;//标志位，判断输出语句是否输出
	public void setting() {
		leadingrole=new LeadingRole();
		System.out.println("请输入主角名称:");
		Scanner inputN = new Scanner(System.in);
		leadingrole.name = inputN.next();
		
		System.out.println("请输入主角生命值:");
		Scanner inputL = new Scanner(System.in);
		leadingrole.initialLifeValue=inputL.nextInt();
		
		System.out.println("请输入主角攻击力:");
		Scanner inputA = new Scanner(System.in);
		leadingrole.aggressivity=inputA.nextInt();
		
		System.out.println("请输入主角防御力:");
		Scanner inputD = new Scanner(System.in);
		leadingrole.defensivePower=inputD.nextInt();
		
		System.out.println("请输入主角敏捷:");
		Scanner inputAG = new Scanner(System.in);
		leadingrole.agile=inputAG.nextInt();
		
		System.out.println("请设置游戏难度");
		Scanner inputDF = new Scanner(System.in);
		this.gameDifficulty=inputDF.nextInt();
	}
	//小怪初始化并开始游戏
	public void startGame1() {
		switch(this.gameDifficulty) {
		case 1:
			monster=new Monster(1);
			monster.initialize();
		if(k1==0) {
			System.out.println(leadingrole.name+" 进入 "+monster.address+"，遇到了3个"+monster.name+"。");
			k1++;
		}
		break;
		case 2:
			monster=new Monster(2);
			monster.initialize();
			if(k2==0) {
				System.out.println(leadingrole.name+" 进入 "+monster.address+"，遇到了3个"+monster.name+"。");
				k2++;
			}
			break;
		case 3:
			monster=new Monster(3);
			monster.initialize();
			if(k3==0) {
				System.out.println(leadingrole.name+" 进入 "+monster.address+"，遇到了3个"+monster.name+"。");
				k3++;
			}
			break;
		case 4:
			monster=new Monster(4);
			monster.initialize();
			if(k4==0) {
				System.out.println(leadingrole.name+" 进入 "+monster.address+"，遇到了3个"+monster.name+"。");
				k4++;
			}
			break;
		case 5:
			monster=new Monster(5);
			monster.initialize();
			if(k5==0) {
				System.out.println(leadingrole.name+" 进入 "+monster.address+"，遇到了3个"+monster.name+"。");
				k5++;
			}
			break;
		case 6:
			monster=new Monster(6);
			monster.initialize();
			if(k6==0) {
				System.out.println(leadingrole.name+" 进入 "+monster.address+"，遇到了3个"+monster.name+"。");
				k6++;
			}
			break;
		case 7:
			monster=new Monster(7);
			monster.initialize();
			if(k7==0) {
				System.out.println(leadingrole.name+" 进入 "+monster.address+"，遇到了3个"+monster.name+"。");
				k7++;
			}
			break;
		case 8:
			monster=new Monster(8);
			monster.initialize();
			if(k8==0) {
				System.out.println(leadingrole.name+" 进入 "+monster.address+"，遇到了3个"+monster.name+"。");
				k8++;
			}
			break;
		case 9:
			monster=new Monster(9);
			monster.initialize();
			if(k9==0) {
				System.out.println(leadingrole.name+" 进入 "+monster.address+"，遇到了3个"+monster.name+"。");
				k9++;
			}
			break;
		case 10:
			monster=new Monster(10);
			monster.initialize();
			if(k10==0) {
				System.out.println(leadingrole.name+" 进入 "+monster.address+"，遇到了3个"+monster.name+"。");
				k10++;
			}
			break;
			default:
				
				break;
		}
	}
	//boss初始化并开始游戏
	public void startGame2() {
		switch(this.gameDifficulty+10) {
		case 11:
			monster=new Monster(11);
			monster.initialize();
			System.out.println(leadingrole.name+"遇到了BOSS-"+monster.name+"。");
		break;
		case 12:
			monster=new Monster(12);
			monster.initialize();
			System.out.println(leadingrole.name+"遇到了BOSS-"+monster.name+"。");
			break;
		case 13:
			monster=new Monster(13);
			monster.initialize();
			System.out.println(leadingrole.name+"遇到了BOSS-"+monster.name+"。");
			break;
		case 14:
			monster=new Monster(14);
			monster.initialize();
			System.out.println(leadingrole.name+"遇到了BOSS-"+monster.name+"。");
			break;
		case 15:
			monster=new Monster(15);
			monster.initialize();
			System.out.println(leadingrole.name+"遇到了BOSS-"+monster.name+"。");
			break;
		case 16:
			monster=new Monster(16);
			monster.initialize();
			System.out.println(leadingrole.name+"遇到了BOSS-"+monster.name+"。");
			break;
		case 17:
			monster=new Monster(17);
			monster.initialize();
			System.out.println(leadingrole.name+"遇到了BOSS-"+monster.name+"。");
			break;
		case 18:
			monster=new Monster(18);
			monster.initialize();
			System.out.println(leadingrole.name+"遇到了BOSS-"+monster.name+"。");
			break;
		case 19:
			monster=new Monster(19);
			monster.initialize();
			System.out.println(leadingrole.name+"遇到了BOSS-"+monster.name+"。");
			break;
		case 20:
			monster=new Monster(20);
			monster.initialize();
			System.out.println(leadingrole.name+"遇到了BOSS-"+monster.name+"。");
			break;
			default:
				
				break;
		}
	}
	public void beat()  {
		int i=0,j=0;
		int value1=leadingrole.aggressivity-monster.defensivePower;
		if(value1<0) {
			value1=0;
		}
		int value2=monster.aggressivity-leadingrole.defensivePower;
		if(value2<0) {
			value2=0;
		}
		while(monster.initialLifeValue>0&&leadingrole.initialLifeValue>0) {
			if(leadingrole.agile>=monster.agile&&i<=j) {
				System.out.println(leadingrole.name+" 对"+
			monster.name+" 发起了进攻, "+"对"+monster.name+"造成了"+value1+"点伤害");
				monster.initialLifeValue=monster.initialLifeValue-value1;
				i++;
			}else if(leadingrole.agile<monster.agile&&i>=j) {
				System.out.println(monster.name+" 对"+
						leadingrole.name+" 发起了进攻, "+"对"+leadingrole.name+"造成了"+value2+"点伤害");
				leadingrole.initialLifeValue=leadingrole.initialLifeValue-value2;
				j++;
			}else if(leadingrole.agile<monster.agile) {
				System.out.println(leadingrole.name+" 对"+
						monster.name+" 发起了进攻, "+"对"+monster.name+"造成了"+value1+"点伤害");
							monster.initialLifeValue=monster.initialLifeValue-value1;
							i++;
			}else if(leadingrole.agile>=monster.agile) {
				System.out.println(monster.name+" 对"+
						leadingrole.name+" 发起了进攻, "+"对"+leadingrole.name+"造成了"+value2+"点伤害");
				leadingrole.initialLifeValue=leadingrole.initialLifeValue-value2;
				j++;
			}
		}
		if(leadingrole.initialLifeValue<=0) {
			System.out.println(leadingrole.name+"体力不支，倒在了"+monster.address+"。");
			System.exit(-1);
		}else {
			System.out.println(monster.name+"死了。");
		}
	}
	public void choose()  {
		System.out.println(leadingrole.name+"继续前进(输入1)");
		System.out.println("*****");
		System.out.println("显示主角"+leadingrole.name+"血量(输入2)");
		Scanner s1=new Scanner(System.in);
		int value=s1.nextInt();
		if(value==2) {
			System.out.println(leadingrole.name+"的当前生命值为"+leadingrole.initialLifeValue);
			
			System.out.println(leadingrole.name+"继续前进(输入1)");
			System.out.println("*****");
			System.out.println(leadingrole.name+"退出游戏(输入0)");
			Scanner s2=new Scanner(System.in);
			int value1=s2.nextInt();
			if(value1==0) {
				System.exit(-1);
			}else if(value1==1) {
				System.out.println(leadingrole.name+"开始继续前进");
			}
		}else if(value==1) {
			System.out.println(leadingrole.name+"开始继续前进");
		}
		
	}
}
