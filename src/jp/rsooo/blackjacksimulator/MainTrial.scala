package jp.rsooo.blackjacksimulator

import scala.collection.immutable.HashMap
import jp.rsooo.blackjacksimulator.data.{CalcResult, Card}
import scala.util.Sorting
import jp.rsooo.blackjacksimulator.data.CalcResult.{ResultRow, ResultNode}

/**
 * Created with IntelliJ IDEA.
 * User: a-saitoh
 * Date: 13/08/21
 * Time: 23:44
 * To change this template use File | Settings | File Templates.
 */
object MainTrial extends App{

  mainTrial;

  val result = new HashMap[Const.Choice, Double]

  def mainTrial = {
//    val playerHand = new Hand();
//    val card = new Card(Card.SuitByID(0), Card.RankByNum(10));
//    val card2 = new Card(Card.SuitByID(0), Card.RankByNum(10));

//
//    playerHand.addCard(card).addCard(card2);
//    println(playerHand.toString)

    val trial = new Trial;
//    trial.trial(10000, playerHand,10, Const.Choice.HIT);

    for(playerCardNum <- (8 to 20).reverse){
      val playerHand = createHand(playerCardNum)

      val resultRow = new ResultRow
      for(upcard <- 2 to 11){
        val hitExpect = trial.trial(10000, playerHand,upcard, Const.Choice.HIT);
        val standExpect = trial.trial(10000, playerHand,upcard, Const.Choice.STAND);
        val doubleExpect = trial.trial(10000, playerHand,upcard, Const.Choice.DOUBLE);

        val resultNode = new ResultNode;
        resultNode.node.put(Const.Choice.HIT,hitExpect)
        resultNode.node.put(Const.Choice.STAND,standExpect)
        resultNode.node.put(Const.Choice.DOUBLE,doubleExpect)
        resultRow.resultRow.put(upcard, resultNode)
      }

      CalcResult.result.put(playerCardNum, resultRow)

    }

//    resultRow.printData
    CalcResult.printData
//   print ( "%1.2f,%1.2f" format (1.23456, 2.991))


//    val a = Array[(Int, Int)]((10,1), (100,0), (1,1), (2,0))
//    Sorting.stableSort(a, ((arg1 : (Int,Int), arg2 : (Int,Int)) => arg1._2 < arg2._2 || arg1._2 == arg2._2 && arg1._1 < arg2._1))
//    for(b <- a)
//      println (b._1 + " " + b._2)
  }

  private def createHand(num : Int) : Hand = {
    val num1 = num /2
    val num2 = num /2 + num % 2

    val playerHand = new Hand();
    val card = new Card(Card.SuitByID(0), Card.RankByNum(num1));
    val card2 = new Card(Card.SuitByID(0), Card.RankByNum(num2));
    playerHand.addCard(card).addCard(card2);
  }
}
