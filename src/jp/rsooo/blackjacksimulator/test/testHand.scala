package jp.rsooo.blackjacksimulator.test

import org.junit._
import Assert._
import org.junit.Test

import jp.rsooo.blackjacksimulator.{Const, DealerStrategy, SimpleDeck, Hand}
import jp.rsooo.blackjacksimulator.data.{CalcResult, Card}
import scala.collection.mutable
import jp.rsooo.blackjacksimulator.data.CalcResult.ResultNode


class testHand {

  @Test def testHand = {
    val hand:Hand = new Hand()
    hand.addCard(new Card(Card.Suit.CLUBS,Card.Rank.KING))
    hand.addCard(new Card(Card.Suit.CLUBS,Card.Rank.ACE))

    assertEquals(21,hand.eval())
    assertEquals(false,hand.isHardHand())

    
    val hand2:Hand = new Hand()
    hand2.addCard(new Card(Card.Suit.CLUBS,Card.Rank.SIX))
    hand2.addCard(new Card(Card.Suit.CLUBS,Card.Rank.SIX))
//    val card:Card = new Card(Card.Suit.CLUBS,Card.Rank.ACE)
    hand2.addCard(new Card(Card.Suit.CLUBS,Card.Rank.ACE))
//    assertEquals(true,Card.Rank.ACE.equals(card.rank))
    assertEquals(13,hand2.eval())
    assertEquals(true,hand2.isHardHand())

    
    val hand3:Hand = new Hand()
    hand3.addCard(new Card(Card.Suit.CLUBS,Card.Rank.ACE))
    hand3.addCard(new Card(Card.Suit.CLUBS,Card.Rank.ACE))
    hand3.addCard(new Card(Card.Suit.CLUBS,Card.Rank.ACE))
    hand3.addCard(new Card(Card.Suit.CLUBS,Card.Rank.ACE))
    assertEquals(14,hand3.eval())
    assertEquals(false,hand3.isHardHand())
    
  }

  @Test def testDealerHand = {
    val hand:Hand = new Hand()
    hand.addCard(new Card(Card.Suit.CLUBS,Card.Rank.SIX))
    assertEquals( hand.eval() , 6 )
    val d : DealerStrategy = new DealerStrategy()
    println(d.makeHand(hand).eval())
  }

  @Test def hoge = {
    val hoge = new mutable.HashMap[String, Any]
    hoge += ("hoge" -> 1)

    val a : ResultNode = new ResultNode
    a.node += (Const.Choice.HIT -> 0.5)
    a.node += (Const.Choice.STAND -> 1.5)
    a.node += (Const.Choice.SPLIT -> 0.2)
    a.printData()



  }
}