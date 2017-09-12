package br.com.zg.pokerhand.model

class ComparadorDeMaos {

	Resultado compareMaos(Mao mao1, Mao mao2) {
		if (mao1.categoria > mao2.categoria) {
			return Resultado.WIN
		} else if (mao1.categoria < mao2.categoria) {
			return Resultado.LOSS
		} else {
			if (mao1.categoria == Categoria.PAIR || mao1.categoria == Categoria.TWO_PAIR) {

				return desempata(mao1, mao2)
			} else {
				return maiorCarta(mao1, mao2)
			}
		}
	}

	Resultado maiorCarta(Mao mao1, Mao mao2) {
		if (mao1.cartas.last() > mao2.cartas.last()) {
			return Resultado.WIN
		} else if (mao1.cartas.last() < mao2.cartas.last()) {
			return Resultado.LOSS
		} else {
			return Resultado.DRAW
		}
	}

	Resultado desempata(Mao mao1, Mao mao2) {
		if (mao1.cartaDesempate > mao2.cartaDesempate) {
			return Resultado.WIN
		} else if (mao1.cartaDesempate < mao2.cartaDesempate) {
			return Resultado.LOSS
		} else {
			return kicker(mao1, mao2)
		}
	}

	Resultado kicker(Mao mao1, Mao mao2) {
		for (int i = 0; i < mao1.cartas.size(); i++) {
			if (mao1.cartas[i] != mao2.cartas[i]) {
				if (mao1.cartas[i] > mao2.cartas[i]) {
					return Resultado.WIN
				} else if (mao1.cartas[i] < mao2.cartas[i]) {
					return Resultado.LOSS
				} else {
					return Resultado.DRAW
				}
			}
		}
	}
}
