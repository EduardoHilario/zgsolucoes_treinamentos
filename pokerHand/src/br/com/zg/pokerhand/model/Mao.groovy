package br.com.zg.pokerhand.model

import static br.com.zg.pokerhand.model.Categoria.*

class Mao {

	List<Carta> cartas = new ArrayList<Carta>()
	Categoria categoria

	Mao(String maoString) {

		String[] maoVetor = maoString.split(" ")

		maoVetor.each {
			cartas << new Carta(it)
		}

		categoria = classificaMao()
	}

	private Categoria classificaMao() {
		cartas.sort()
		if (isRoyalStraightFlush()) {
			return ROYAL_FLUSH
		} else if (isStraightFlush()) {
			return STRAIGHT_FLUSH
		} else if (isFour()) {
			return FOUR
		} else if (isFullHouse()) {
			return FULL_HOUSE
		} else if (isFlush()) {
			return FLUSH
		} else if (isStraight()) {
			return STRAIGHT
		} else if (isThree()) {
			return THREE
		} else if (isTwoPair()) {
			return TWO_PAIR
		} else if (isPair()) {
			return PAIR
		} else {
			return HIGH_CARD
		}
	}

	private boolean existeGrupos(int quantidade, int tamanho){
		return cartas.groupBy {it.valor}.values()
		.findAll {it.size() == tamanho}
		.size() == quantidade
	}

	private boolean isPair(){
		return existeGrupos(1,2)
	}

	private boolean isTwoPair(){
		return existeGrupos(2,2)
	}

	private boolean isThree(){
		return existeGrupos(1,3)
	}

	private boolean isStraight(){
		return (cartas.valor.last().ordinal() - cartas.valor.first().ordinal()) == 4
	}

	private boolean isFlush(){
		return cartas.groupBy {it.naipe}.values().size() == 1
	}

	private boolean isFullHouse() {
		return isPair() && isThree()
	}

	private boolean isFour() {
		return existeGrupos(1,4)
	}

	private boolean isStraightFlush() {
		return isStraight() && isFlush()
	}

	private boolean isRoyalStraightFlush() {
		return cartas.valor[0] == ValorDaCarta.DEZ && isStraightFlush()
	}


	@Override
	String toString() {
		return "Mao{" +
				"cartas=" + cartas +
				", categoria=" + categoria +
				'}'
	}


}
