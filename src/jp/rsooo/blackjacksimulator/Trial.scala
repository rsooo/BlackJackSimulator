package jp.rsooo.blackjacksimulator

class Trial(num : Int, playerHand : Hand, upcardnum : Int) {
	
  def trial() = {
//		 val bet : Int = 1 
	  	 val upCard : Card = new Card(Card.SuitByID(0), Card.RankByID(upcardnum))
	  	 
	  	 var expectation : Double = 0.0
	  	 //stand	  	 
		 for (i <- 1 to num){
			 val dealerHand : Hand = new Hand()
  			 dealerHand.addCard(upCard)
			 dealerHand.addCard(SimpleDeck.pickCard())
			 expectation += compareHand(dealerHand, playerHand, 1)
		 }
	  	 
	  	 print (expectation / num)
		  
  }
  
  def compareHand(dealerHand : Hand, playerHand : Hand, bet : Int) : Double = {
	  val dealerVal = getDealerValue(dealerHand)
	  val playerVal = playerHand.eval()
//	  dealerVal match {
//	    case 
//	  }
	  if(playerVal > 21) return 0.0
	  else if(dealerVal._1 > 21) if(playerHand.isBlackJack()) return bet * 2.5 else return bet * 2.0  
	  else if(playerHand.isBlackJack()) if(dealerHand.isBlackJack()) return bet else return bet * 2.5
	  else if(dealerHand.isBlackJack()) if(playerHand.isBlackJack()) return bet else return 0.0
	  else if(dealerVal._1 > playerVal) return 0.0
	  else if(dealerVal._1 < playerVal) return bet * 2.0
	  else return bet
  }
  
  	def getDealerValue(dealerHand : Hand) : (Int, Hand) = {
	  val value = dealerHand.eval()
	  if ( value >= 17 ){
		  (value,dealerHand)
	  } else{
	    dealerHand.addCard(SimpleDeck.pickCard())
	    getDealerValue(dealerHand)
	  }
	}
  
}