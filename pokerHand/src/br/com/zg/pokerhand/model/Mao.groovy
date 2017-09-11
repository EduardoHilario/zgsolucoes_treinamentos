package br.com.zg.pokerhand.model

class Mao {

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
		} else if (isHighCard()) {
			categoria = Categoria.HIGH_CARD
		}
	}

	boolean isHighCard() {
		boolean is = false


		for (int i = 0; i < cartas.size(); i++) {
			for (int j = 1; j < cartas.size(); j++) {
				if (i != j) {
					is = (cartas[i].compareTo(cartas[j]) != 0)
					if (!is) {
						return false
					}
				}
			}
		}
		return is
	}

	boolean isPair() {
		int c = 0
		for (int i = 0; i < cartas.size(); i++) {
			for (int j = 1; j < cartas.size(); j++) {
				if (i != j) {
					if (cartas[i].compareTo(cartas[j]) == 0) {

						c++
					}
				}
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
		for (int i = 0; i < cartas.size(); i++) {
			for (int j = 1; j < cartas.size(); j++) {
				if (i != j) {
					if (cartas[i].compareTo(cartas[j]) == 0) {

						c++
					}
				}
			}
		}
		if (c == 3) {
			return true
		} else {
			return false
		}

	}

	boolean isTree() {
		int c = 0
		for (int i = 0; i < cartas.size(); i++) {
			for (int j = 1; j < cartas.size(); j++) {
				if (i != j) {
					if (cartas[i].compareTo(cartas[j]) == 0) {

						c++
					}
				}
			}
		}
		if (c == 4) {
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
		for (int i = 0; i < cartas.size(); i++) {
			for (int j = 1; j < cartas.size(); j++) {
				if (i != j) {
					if (cartas[i].compareToNaipe(cartas[j]) == 0) {

						c++
					}
				}
			}
		}
		if (c == 16) {
			return true
		} else {
			return false
		}

	}

	boolean isFullHouse() {
		int c = 0
		for (int i = 0; i < cartas.size(); i++) {
			for (int j = 1; j < cartas.size(); j++) {
				if (i != j) {
					if (cartas[i].compareTo(cartas[j]) == 0) {

						c++
					}
				}
			}
		}
		if (c == 6 || c == 7) {
			return true
		} else {
			return false
		}

	}

	boolean isFour() {
		int c = 0
		for (int i = 0; i < cartas.size(); i++) {
			for (int j = 1; j < cartas.size(); j++) {
				if (i != j) {
					if (cartas[i].compareTo(cartas[j]) == 0) {

						c++
					}
				}
			}
		}
		if (c == 9) {
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
