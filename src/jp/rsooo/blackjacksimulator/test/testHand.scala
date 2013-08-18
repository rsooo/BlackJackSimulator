package jp.rsooo.blackjacksimulator.test

import org.junit._
import Assert._
import jp.rsooo.blackjacksimulator.Hand
import jp.rsooo.blackjacksimulator.Card


class testHand {

  @Test def testHand{
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
}