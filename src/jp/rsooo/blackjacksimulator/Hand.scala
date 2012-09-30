package jp.rsooo.blackjacksimulator

class Hand {

  var cards:List[Card] = List();
 
  def eval() : Int = {
    eval(cards)
  }
  
  private def eval(cards:List[Card]) : Int = {
    val fullsum = 
      if(cards.isEmpty) 0
      	else{
      		cards.head.Value() + eval(cards.tail)
      	}
    adjustSumValue(fullsum, countAce(cards))
  }
  
  def adjustSumValue(fullsum:Int, aceCount:Int) : Int = {
    if (aceCount == 0) fullsum else{
    	if(fullsum <= 21) fullsum else{
    		adjustSumValue(fullsum - 10, aceCount - 1)
    	}  
    }
  }
  
  def countAce(cards:List[Card]):Int = {
    if (cards.isEmpty ) 0 
    else{ 
      if ( cards.head.rank == Card.Rank.ACE) {1} else {0}
      + countAce(cards.tail)
    }
  }
  
  def addCard(card:Card) = {
    cards = card :: cards
  }
}