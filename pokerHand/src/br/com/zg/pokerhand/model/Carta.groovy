package br.com.zg.pokerhand.model

class Carta implements Comparable {

	ValorDaCarta valor
	NaipeDaCarta naipe


	@Override
	String toString() {
		return "\nCarta{" +
				"valor=" + valor +
				", naipe=" + naipe +
				'}'
	}

	@Override
	int compareTo(Object o) {
		Carta c = o as Carta
		if (c.valor == valor) {
			return 0
		} else if (c.valor > valor) {
			return -1
		} else {
			return 1
		}
	}

	int compareToNaipe(Object o) {
		Carta c = o as Carta
		if (c.naipe == naipe) {
			return 0
		} else if (c.naipe < naipe) {
			return -1
		} else {
			return 1
		}
	}
}