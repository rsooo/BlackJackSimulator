package jp.rsooo.blackjacksimulator

import jp.rsooo.blackjacksimulator.{SimpleDeck, Const, Hand}

/**
 * Created with IntelliJ IDEA.
 * User: a-saitoh
 * Date: 13/08/20
 * Time: 0:21
 * To change this template use File | Settings | File Templates.
 */
class DealerStrategy {

  def nextChoice(dealerHand: Hand) : Const.Choice = {
    if (dealerHand.eval() < 17 ) return Const.Choice.HIT
    else Const.Choice.STAND
  }

  def makeHand(dealerHand : Hand) : Hand = {
    if( dealerHand.eval() > 21 ) dealerHand
    else if (nextChoice(dealerHand) == Const.Choice.STAND) dealerHand
    else makeHand(dealerHand.addCard(SimpleDeck.pickCard()))
  }
}
