package com.qh.practice;
/**
 * 游戏操作类
 * @author Administrator
 *
 */
public class GamePlay {
        public static void main(String[] args) throws Throwable  {
        	
        	GamePlay gameplay1=new GamePlay();
        	GameSetting gameSetting1=gameplay1.settingGame();

        	while(gameSetting1.leadingrole.initialLifeValue>0&&gameSetting1.gameDifficulty<11) {
        		gameplay1.startGame(gameSetting1);
        	}
        	if(gameSetting1.gameDifficulty==11) {
        		System.out.println(gameSetting1.leadingrole.name+"闯过所有关卡，将敌人一网打尽！");
        	}
        }
        public  GameSetting settingGame() {
        	     GameSetting game=new GameSetting();
			     game.setting();
                 return game;
        }
        public   void startGame(GameSetting game) throws Throwable {
        	
    		//第一波
			for(int i=0;i<3;i++) {
				game.startGame1();
			    game.beat();
			}
		  game.choose();//用户进行选择
		  //第二波
		 for(int i=0;i<3;i++) {
			game.startGame1();
		    game.beat();
		 }
		 game.choose();//用户进行选择
		 //第三波
		 game.startGame2();
		 game.beat();
		 game.choose();//用户进行选择
		 game.gameDifficulty++;
		}
        }

