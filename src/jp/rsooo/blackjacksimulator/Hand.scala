package jp.rsooo.blackjacksimulator

import jp.rsooo.blackjacksimulator.data.Card

class Hand(c : List[Card]) {
  var cards:List[Card] = c;

  def this() = this(Nil)
//  def this(cards : List[Card]) = {
//
//  }

  def eval() : Int = {
    eval(cards)
  }

//  def evelWithCard(newCard: Card) : Int = {
//    eval(newCard :: cards)
//  }
  
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
    if (countAce(cards) == 0) return true

    val fullsum = calcFullSum(cards)
//    println("Ace " + countAce(cards))
//    println("val:" + (fullsum - 10 * countAce(cards)) + ":" + eval())
//    print (countAce(cards))
    (fullsum - 10 * countAce(cards)) > 11
  }
  
  def initHand() = {
    cards = List();
 
  }
  
  def isBlackJack() : Boolean = {
    if (cards.length == 2 && eval() == 21) return true
    return false
  }

  def handType = {
    if (isHardHand) Const.HARDHAND else{
      //print ("softhand" + this.eval().toString)
      Const.SOFTHAND
    }
  }

  override def toString : String = {
    cards.mkString("[", ",", "]")
  }

  def splist() : (Hand, Hand) = {
    if(cards.length != 2){
      print("something wrong")
      return (null,null)
    }
    val cards1 = List(cards.apply(0))
    val cards2 = List(cards.apply(1))
    (new Hand(cards1), new Hand(cards2))
  }
}