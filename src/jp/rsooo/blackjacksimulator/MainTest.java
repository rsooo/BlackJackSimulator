package jp.rsooo.blackjacksimulator;


import jp.rsooo.blackjacksimulator.etc.ObjTest2;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hand playerHand = new Hand();
		Card card = new Card(Card.SuitByID(0), Card.RankByID(10));
		Card card2 = new Card(Card.SuitByID(0), Card.RankByID(12));

		playerHand.addCard(card).addCard(card2);
		
		Trial trial = new Trial(10000, playerHand,3);
		trial.trial();
		//		System.out.println("HelloWorld!!");
//		ScalaObjTest.test();
//		ObjTest2.hoge();
//		Card c = new Card();
////		SimpleDeck simpleDeck = SimpleDeck.;
//		
//		Hand h = new Hand();
//		h.addCard(c);
//		h.addCard(new Card(Card.Suit.CLUBS, Card.Rank.EIGHT));
//		h.addCard(simpleDeck.pickCard());
//		h.addCard(simpleDeck.pickCard());
//		h.addCard(simpleDeck.pickCard());
//		h.addCard(simpleDeck.pickCard());
////		System.out.println(h.eval());
//		h.printHand();
//		Game game = new Game();
//		game.play();

		
//		if (Choice.DOUBLE()Choice.HIT()){
//			System.out.println(Choice.DOUBLE());
//		}
	}
	
}
