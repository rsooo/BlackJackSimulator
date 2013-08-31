package jp.rsooo.blackjacksimulator;

public class Const {
	public enum Choice{
		HIT,STAND,DOUBLE,SPLIT,SALENDER,MANUAL;
	}
	
	public enum GameState{
		BET, PLAY, SHOW_DOWN, FINISHED
	}

    public static final int HARDHAND = 0;
    public static final int SOFTHAND = 1;
    public static final int SPLITABLE = 2;

//    public enum HandType{
//        SOFT, HARD
//    }
}
