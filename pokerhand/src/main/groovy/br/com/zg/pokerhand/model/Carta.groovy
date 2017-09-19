package br.com.zg.pokerhand.model

class Carta implements Comparable<Carta> {

	ValorDaCarta valor
	NaipeDaCarta naipe

	Carta(String cartaString){
		switch (cartaString[0]){
			case '2':
				valor = ValorDaCarta.DOIS
				break
			case '3':
				valor = ValorDaCarta.TRES
				break
			case '4':
				valor = ValorDaCarta.QUATRO
				break
			case '5':
				valor = ValorDaCarta.CINCO
				break
			case '6':
				valor = ValorDaCarta.SEIS
				break
			case '7':
				valor = ValorDaCarta.SETE
				break
			case '8':
				valor = ValorDaCarta.OITO
				break
			case '9':
				valor = ValorDaCarta.NOVE
				break
			case 'T':
				valor = ValorDaCarta.DEZ
				break
			case 'J':
				valor = ValorDaCarta.VALETE
				break
			case 'Q':
				valor = ValorDaCarta.RAINHA
				break
			case 'K':
				valor = ValorDaCarta.REI
				break
			case 'A':
				valor = ValorDaCarta.ACE
				break
		}
		switch (cartaString[1]){
			case 'S':
				naipe = NaipeDaCarta.ESPADAS
				break
			case 'H':
				naipe = NaipeDaCarta.COPAS
				break
			case 'D':
				naipe = NaipeDaCarta.OUROS
				break
			case 'C':
				naipe = NaipeDaCarta.PAUS
				break
		}
	}

	@Override
	String toString() {
		return "\nCarta{" +
				"valor=" + valor +
				", naipe=" + naipe +
				'}'
	}

	@Override
	int compareTo(Carta o) {

		return this.valor.ordinal() - o.valor.ordinal()
	}

}