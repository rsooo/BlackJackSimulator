package jp.rsooo.blackjacksimulator.data

import jp.rsooo.blackjacksimulator.Const
import scala.collection.mutable
import scala.util.Sorting


/**
 * Created with IntelliJ IDEA.
 * User: a-saitoh
 * Date: 13/08/21
 * Time: 23:30
 * To change this template use File | Settings | File Templates.
 */
object CalcResult {

  //プレイヤーHandとその結果のマップ
  val result =  new mutable.HashMap[(Int,Int), ResultRow]

  def printData = {
    println(this.toString)
  }

  override def toString = {
    val array = result.keySet.toArray
    //Sorting.stableSort(array)
    Sorting.stableSort(array, (x : (Int,Int), y : (Int,Int)) => x._2 < y._2 || x._2 == y._2 && x._1 < y._1)
    var retString = ""
    for(key <- array){
      val htype = key._2 match {
        case Const.HARDHAND => "H"
        case Const.SOFTHAND => "S"
        case Const.SPLITABLE => "SP"
      }
      retString += key._1.toString + htype +  "# "
      retString += (result.get(key) match {
        case Some(node) => node.toString
        case None => "Something wrong"
      })
      retString += "\n"
    }
    retString
  }

  class ResultRow{
    //(ディーラーのupcard値とその結果のMap
    var resultRow = new mutable.HashMap[Int, ResultNode ] // false hard, true soft

    def printData = {
      println(this.toString)
    }
    override def  toString = {
      val array = resultRow.keySet.toArray
//      Sorting.stableSort((x : (Int,Int), y : (Int,Int)) => x._2 < y._2 || x._2 == y._2 && x._1 < y._1)
      Sorting.stableSort(array)
      var retString = ""
      for(key <- array){
        retString +=  (resultRow.get(key) match {
          case Some(node) => node.toString
          case None => "Something wrong"
        })
        retString += " "
      }
      retString
    }

  }

  class ResultNode{
    var node  = new mutable.HashMap[Const.Choice, Double]

    def printData() = {
      println(this.toString)
//      print (hit + "/" + stand + "/" + double + "/" + split);
      //printfにする
    }

    override def toString = {

      val hit = node.get(Const.Choice.HIT) match {
        case Some(f) => f
        case None    => 0.0
      }
      val stand = node.get(Const.Choice.STAND) match {
        case Some(f) => f
        case None    => 0.0
      }
      val double = node.get(Const.Choice.DOUBLE) match {
        case Some(f) => f
        case None    => 0.0
      }
      val split = node.get(Const.Choice.SPLIT) match {
        case Some(f) => f
        case None    => 0.0
      }
      node.get(Const.Choice.SPLIT) match {
        case Some(f) =>  ("%1.3f" format split)
        case None =>      ("%1.3f/%1.3f/%1.3f" format (hit, stand, double))
      }

//      "%1.2f_%1.2f_%1.2f_%1.2f" format (hit, stand, double, split)
//      ("%1.2f_%1.2f_%1.2f_%1.2f" format (hit, stand, double, split))

    }

    def getBest : Double = {
      node.valuesIterator.max
    }
  }


}
