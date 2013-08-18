package jp.rsooo.blackjacksimulator


class Strategy(lowerHit : Int, upperStand: Int) {
    val lowerHitValue = lowerHit
    val upperStandValue = upperStand
	val H : Const.Choice = Const.Choice.HIT
	val S : Const.Choice = Const.Choice.STAND
	val D : Const.Choice = Const.Choice.DOUBLE
	val P : Const.Choice = Const.Choice.SPLIT
	
	val hardHandStrategy : Array[Array[Const.Choice]]=  Array(
		//    2  3  4  5  6  7  8  9 10  A
		Array(H, D, D, D, D, H, H, H, H, H),	/* 9*/
	    Array(D, D, D, D, D, D, D, D, H, H),	/*10*/
	    Array(D, D, D, D, D, D, D, D, D, H),	/*11*/
	    Array(H, H, S, S, S, H, H, H, H, H),	/*12*/
	    Array(S, S, S, S, S, H, H, H, H, H),	/*13*/
	    Array(S, S, S, S, S, H, H, H, H, H),	/*14*/
	    Array(S, S, S, S, S, H, H, H, H, H),	/*15*/
	    Array(S, S, S, S, S, H, H, H, H, H)		/*16*/
	)

	val softHandStrategy : Array[Array[Const.Choice]]=  Array(
		//    2  3  4  5  6  7  8  9 10  A
	    Array(H, H, H, D, D, H, H, H, H, H),	/*13(A 2)*/
	    Array(H, H, H, D, D, H, H, H, H, H),	/*14(A 3)*/
	    Array(H, H, D, D, D, H, H, H, H, H),	/*15(A 4)*/
	    Array(H, H, D, D, D, H, H, H, H, H),	/*16(A 5)*/
	    Array(H, D, D, D, D, H, H, H, H, H),	/*17(A 6)*/
	    Array(S, D, D, D, D, S, S, H, H, H)		/*18(A 7)*/
	)

	
	
	def hoge() = {
    	
    }
}