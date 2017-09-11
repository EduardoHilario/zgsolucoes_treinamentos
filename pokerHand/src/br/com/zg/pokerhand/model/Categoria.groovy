package br.com.zg.pokerhand.model

enum Categoria {

	ROYAL_FLUSH(1), STRAIGHT_FLUSH(2), FOUR(3), FULL_HOUSE(4), FLUSH(5)
	, STRAIGHT(6), THREE(7), TWO_PAIR(8), PAIR(9), HIGH_CARD(10)

	Integer rankPosition

	Categoria(Integer rankPosition) {
		this.rankPosition = rankPosition
	}
}