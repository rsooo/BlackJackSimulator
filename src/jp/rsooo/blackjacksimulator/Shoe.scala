package jp.rsooo.blackjacksimulator

import jp.rsooo.blackjacksimulator.data.Card

trait Shoe {
	def pickCard(): Card
	def shuffle
	
}