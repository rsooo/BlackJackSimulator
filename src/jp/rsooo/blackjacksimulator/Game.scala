package jp.rsooo.blackjacksimulator
import jp.rsooo.blackjacksimulator.SimpleDeck

class Game {
//	val dealerHand : Hand
//	val player : List[Hand]
	val deck = SimpleDeck;
	
	def play(){
		val dealerHand : Hand = new Hand();
		dealerHand.addCard(deck.pickCard()).addCard(deck.pickCard())
		getDealerValue(dealerHand)
//		dealerHand.printHand()
	}
	
	def getDealerValue(dealerHand : Hand) : (Int, Hand) = {
	  var value = dealerHand.eval()
	  if ( value >= 17 ){
		  (value,dealerHand)
	  } else{
	    dealerHand.addCard(deck.pickCard())
	    getDealerValue(dealerHand)
	  }
	}
	
	def getPlayerValue(playerHand : Hand, upcard : Int){
	  
	}
}