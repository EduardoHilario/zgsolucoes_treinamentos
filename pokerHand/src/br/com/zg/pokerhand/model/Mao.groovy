package br.com.zg.pokerhand.model

class Mao {

	static void main(String[] args) {

		separeCartas("KS")

	}

	static List<Carta> separeCartas(String mao) {
		Carta carta = new Carta()
		List<Carta> cartas = new ArrayList<Carta>()

		for (int i = 1; i < mao.length(); i++) {
			if (i == 1) {
				println(mao[i - 1] + mao[i])
				carta = identifiqueCarta(mao[i - 1] + mao[i])
				print(carta.toString())

			} else if (i % 3 == 0) {

				println(mao[i] + mao[i + 1])
				carta = identifiqueCarta(mao[i] + mao[i + 1])
				carta.toString()
			}
		}

	}

	static Carta identifiqueCarta(String carta) {

		//List<ValorDaCarta> listaDeValores = ArrayList.asList(ValorDaCarta.values())

		Carta novaCarta = new Carta()

		carta.each {
			switch (it) {
				case '2':
					novaCarta.valor(ValorDaCarta.DOIS)
					break
				case '3':
					novaCarta.valor(ValorDaCarta.TRES)
					break
				case '4':
					novaCarta.valor(ValorDaCarta.QUATRO)
					break
				case '5':
					novaCarta.valor(ValorDaCarta.CINCO)
					break
				case '6':
					novaCarta.valor(ValorDaCarta.SEIS)
					break
				case '7':
					novaCarta.valor(ValorDaCarta.SETE)
					break
				case '8':
					novaCarta.valor(ValorDaCarta.OITO)
					break
				case '9':
					novaCarta.valor(ValorDaCarta.NOVE)
					break
				case '10':
					novaCarta.valor(ValorDaCarta.DEZ)
					break
				case 'J':
					novaCarta.valor(ValorDaCarta.VALETE)
					break
				case 'Q':
					novaCarta.valor(ValorDaCarta.RAINHA)
					break
				case 'K':
					novaCarta.setValor(ValorDaCarta.REI)
					break
				case 'A':
					novaCarta.valor(ValorDaCarta.ACE)
					break
				case 'S':
					novaCarta.setNaipe(NaipeDaCarta.ESPADAS)
					break
				case 'H':
					novaCarta.naipe(NaipeDaCarta.COPAS)
					break
				case 'D':
					novaCarta.naipe(NaipeDaCarta.OUROS)
					break
				case 'C':
					novaCarta.naipe(NaipeDaCarta.PAUS)
					break
			}
		}
		return novaCarta
	}
}
