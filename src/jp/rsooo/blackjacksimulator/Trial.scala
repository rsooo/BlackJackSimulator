package jp.rsooo.blackjacksimulator

import jp.rsooo.blackjacksimulator.data.{CalcResult, Card}

class Trial() {

  val Bet : Int = 1;

  def trial(num : Int, playerInitHand : Hand, upcardnum : Int, strategy : Const.Choice) : Double = {
//		 val bet : Int = 1 
	  	 val upCard : Card = new Card(Card.SuitByID(0), Card.RankByNum(upcardnum))
//	  	 println(upCard.toString)
	  	 var expectation : Double = 0.0
	  	 //stand
   // val strategy : DealerStrategy = new DealerStrategy();

		 for (i <- 1 to num){
			 val dealerHand : Hand = new Hand(upCard :: Nil)
//       println("dealerHand" + dealerHand.toString)
         if(strategy == Const.Choice.HIT){
           val playerHitHand = new Hand(SimpleDeck.pickCard() :: playerInitHand.cards)
           if (playerHitHand.eval() < 21){
             expectation += CalcResult.result.get(playerHitHand.eval()).get.resultRow.get(upcardnum).get.getBest
           }else{
             expectation += compareHand(dealerHand, playerHitHand, Bet)
           }
         }
         else if(strategy.equals(Const.Choice.STAND)){
           expectation += compareHand(dealerHand, playerInitHand, Bet)
         }else if(strategy.equals(Const.Choice.DOUBLE)){
           val playerHitHand = new Hand(SimpleDeck.pickCard() :: playerInitHand.cards)
           expectation += compareHand(dealerHand, playerHitHand, Bet * 2)

         }else{
           println ("wrong status")
         }

       //val dHand = strategy.makeHand(dealerHand)
      // println(dHand.eval())
//			 dealerHand.addCard(SimpleDeck.pickCard())
		 }
	  	 
	  	//print (expectation / num - Bet)
    expectation / num
  }
  
  def compareHand(dealerHand : Hand, playerHand : Hand, bet : Int) : Double = {
	  val dealerVal = getDealerValue(dealerHand)
 //   println(dealerVal)
	  val playerVal = playerHand.eval()
//	  dealerVal match {
//	    case 
//	  }
//    println(playerVal)
	  if(playerVal > 21) return -bet
	  else if(dealerVal._1 > 21) if(playerHand.isBlackJack()) return bet * 1.5 else return bet
	  else if(playerHand.isBlackJack()) if(dealerHand.isBlackJack()) return bet else return bet
	  else if(dealerHand.isBlackJack()) if(playerHand.isBlackJack()) return bet else return -bet
	  else if(dealerVal._1 > playerVal) return -bet
	  else if(dealerVal._1 < playerVal) return bet
	  else return 0
  }
  
  	def getDealerValue(dealerHand : Hand) : (Int, Hand) = {
	  val value = dealerHand.eval()
//    println(dealerHand.toString)
	  if ( value >= 17 ){
		  (value,dealerHand)
	  } else{
      val dealerHitHand = new Hand(SimpleDeck.pickCard() :: dealerHand.cards)
	    //dealerHand.addCard(SimpleDeck.pickCard())
	    getDealerValue(dealerHitHand)
	  }
	}
  
}