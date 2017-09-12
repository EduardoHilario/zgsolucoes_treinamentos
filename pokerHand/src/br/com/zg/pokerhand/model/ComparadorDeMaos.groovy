package br.com.zg.pokerhand.model

class ComparadorDeMaos {

	Resultado compareMaos(Mao mao1, Mao mao2) {
		if (mao1.categoria > mao2.categoria) {
			return Resultado.WIN
		} else if (mao1.categoria < mao2.categoria) {
			return Resultado.LOSS
		} else {
			return Resultado.DRAW
		}
	}
}
