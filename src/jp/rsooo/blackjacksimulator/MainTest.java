package jp.rsooo.blackjacksimulator;

import jp.rsooo.blackjacksimulator.etc.ObjTest2;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("HelloWorld!!");
//		ScalaObjTest.test();
//		ObjTest2.hoge();
		Card c = new Card();
		
		Hand h = new Hand();
		h.addCard(c);
		h.addCard(new Card(Card.Suit.CLUBS, Card.Rank.EIGHT));
		System.out.println(h.eval());
		
	}
	
}
