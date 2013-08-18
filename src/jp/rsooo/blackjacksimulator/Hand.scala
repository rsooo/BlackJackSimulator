package jp.rsooo.blackjacksimulator

class Hand(card : Card) {
  if (card != null) {
	  this.addCard(card)
  }
  
  def this() = this(null)
  
  var cards:List[Card] = List();
 
  def eval() : Int = {
    eval(cards)
  }
  
  private def eval(cards:List[Card]) : Int = {
//    println("eval Ace" + countAce(cards))
    adjustSumValue(calcFullSum(cards), countAce(cards))
  }
  
  private def calcFullSum(cards:List[Card]) : Int = {
      if(cards.isEmpty) return 0
      	else{
      		cards.head.Value() + calcFullSum(cards.tail)
      	}
  }
  
  def adjustSumValue(fullsum:Int, aceCount:Int) : Int = {
    if (aceCount == 0) return fullsum else{
    	if(fullsum <= 21) return fullsum else{
    		adjustSumValue(fullsum - 10, aceCount - 1)
    	}  
    }
  }
  
  def countAce(cards:List[Card]):Int = {
    if (cards.isEmpty ) return 0 
    else{ 
      return ((if ( cards.head.rank == Card.Rank.ACE) {1} else {0})
       + countAce(cards.tail))
    }
  }
  
  def addCard(card:Card) : Hand = {
    cards = card :: cards
    this
  }
  
  def printHand() = {
    println("Value:" + eval())
    for (card <- cards) println(Card.StringByCard(card) ) 
  }
  
  def isHardHand() : Boolean = {
    val fullsum = calcFullSum(cards)
//    println("Ace " + countAce(cards))
//    println("val:" + (fullsum - 10 * countAce(cards)) + ":" + eval())
    fullsum - 10 * countAce(cards) == eval()
  }
  
  def initHand() = {
    cards = List();
 
  }
  
  def isBlackJack() : Boolean = {
    if (cards.length == 2 && eval() == 21) return true
    return false
  }

}