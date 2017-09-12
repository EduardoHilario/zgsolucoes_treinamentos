package br.com.zg.pokerhand.model

class Mao {

	Carta cartaDesempate = new Carta()
	List<Carta> cartas = new ArrayList<Carta>()
	Categoria categoria


	void ordenaMao() {
		cartas.sort()
	}

	void classificaMao() {
		ordenaMao()
		if (isRoyalStraightFlush()) {
			categoria = Categoria.ROYAL_FLUSH
		} else if (isStraightFlush()) {
			categoria = Categoria.STRAIGHT_FLUSH
		} else if (isFour()) {
			categoria = Categoria.FOUR
		} else if (isFullHouse()) {
			categoria = Categoria.FULL_HOUSE
		} else if (isFlush()) {
			categoria = Categoria.FLUSH
		} else if (isStraight()) {
			categoria = Categoria.STRAIGHT
		} else if (isTree()) {
			categoria = Categoria.THREE
		} else if (isTwoPair()) {
			categoria = Categoria.TWO_PAIR
		} else if (isPair()) {
			categoria = Categoria.PAIR
		} else  {
			categoria = Categoria.HIGH_CARD
		}
	}


	boolean isPair() {
		int c = 0
		for (int i = 0; i < cartas.size() - 1; i++) {
			if (cartas[i] == cartas[i + 1]) {
				cartaDesempate = cartas[i]
				c++
			}
		}
		if (c == 1) {
			return true
		} else {
			return false
		}

	}

	boolean isTwoPair() {
		int c = 0
		for (int i = 0; i < cartas.size() - 1; i++) {
			if (cartas[i] == cartas[i + 1]) {
				cartaDesempate = cartas[i]
				if(cartas[i] > cartaDesempate){
					cartaDesempate = cartas[i]
				}
				c++
			}
		}
		if (c == 2) {
			return true
		} else {
			return false
		}

	}

	boolean isTree() {
		int c = 0
		for (int i = 0; i < cartas.size() - 1; i++) {
			if (cartas[i] == cartas[i + 1] && cartas[i] == cartas[i + 2]) {

				c++
			}
		}
		if (c == 1) {
			return true
		} else {
			return false
		}

	}

	boolean isStraight() {
		int c = 0
		for (int i = 0; i < cartas.size() - 1; i++) {

			int proximoDaSequencia = cartas[i + 1].valor.valorNum
			proximoDaSequencia--

			if (cartas[i].valor.valorNum == proximoDaSequencia) {
				c++
			}

		}

		if (c == 4) {
			return true
		} else {
			return false
		}

	}

	boolean isFlush() {
		int c = 0
		for (int i = 0; i < cartas.size() - 1; i++) {
			if (cartas[i].naipe == (cartas[i + 1].naipe)) {

				c++
			}
		}
		if (c == 4) {
			return true
		} else {
			return false
		}

	}

	boolean isFullHouse() {
		if (isTree()) {
			if (cartas[0] == cartas[1] && cartas[3] == cartas[4]) {
				return true
			} else {
				return false
			}
		} else {
			return false
		}


	}

	boolean isFour() {
		int c = 0
		for (int i = 0; i < cartas.size() - 1; i++) {
			if (cartas[i] == cartas[i + 1] && cartas[i] == cartas[i + 2] && cartas[i] == cartas[i + 3]) {

				c++
			}
		}
		if (c == 1) {
			return true
		} else {
			return false
		}

	}

	boolean isStraightFlush() {

		if (isStraight() && isFlush()) {
			return true
		}

		return false

	}

	boolean isRoyalStraightFlush() {

		if (cartas.valor[0].valorNum == 10 && isStraight() && isFlush()) {
			return true
		}

		return false


	}


	@Override
	String toString() {
		return "Mao{" +
				"cartas=" + cartas +
				", categoria=" + categoria +
				'}'
	}


}
