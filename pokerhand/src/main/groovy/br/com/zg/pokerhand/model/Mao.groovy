package br.com.zg.pokerhand.model

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
			return Categoria.ROYAL_FLUSH
		} else if (isStraightFlush()) {
			return Categoria.STRAIGHT_FLUSH
		} else if (isFour()) {
			return Categoria.FOUR
		} else if (isFullHouse()) {
			return Categoria.FULL_HOUSE
		} else if (isFlush()) {
			return Categoria.FLUSH
		} else if (isStraight()) {
			return Categoria.STRAIGHT
		} else if (isThree()) {
			return Categoria.THREE
		} else if (isTwoPair()) {
			return Categoria.TWO_PAIR
		} else if (isPair()) {
			return Categoria.PAIR
		} else {
			return Categoria.HIGH_CARD
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
