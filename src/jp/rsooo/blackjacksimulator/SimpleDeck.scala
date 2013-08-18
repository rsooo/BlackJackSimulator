package jp.rsooo.blackjacksimulator
import java.util.EnumSet
import java.util.Random

/**
 * �ł��P���ȃf�b�L
 */
object SimpleDeck extends Shoe {
    
    val rand : Random = new Random()
    
    
	def pickCard() : Card = {
			var suit = rand.nextInt(4)
			var rank = rand.nextInt(14)
			new Card(Card.SuitByID(suit), Card.RankByID(rank))
	}
    
    def shuffle() = {}
}