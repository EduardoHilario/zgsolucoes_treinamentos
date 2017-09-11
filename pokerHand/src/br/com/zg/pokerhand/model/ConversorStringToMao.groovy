package br.com.zg.pokerhand.model

class ConversorStringToMao {

	static Mao obterMao(String maoString){
		Mao mao = new Mao()
		//Carta carta = new Carta()
		//Obter cartas separadas
		String[] cartas = maoString.split(" ")

		cartas.each {
			Carta carta = new Carta()
			mao.cartas << obterNaipe(obterValor(carta,it[0] as char),it[1] as char)
		}

		return mao
	}

	static Carta obterValor(Carta carta, char valorString){
		switch (valorString){
			case '2':
				carta.valor = ValorDaCarta.DOIS
				break
			case '3':
				carta.valor = ValorDaCarta.TRES
				break
			case '4':
				carta.valor = ValorDaCarta.QUATRO
				break
			case '5':
				carta.valor = ValorDaCarta.CINCO
				break
			case '6':
				carta.valor = ValorDaCarta.SEIS
				break
			case '7':
				carta.valor = ValorDaCarta.SETE
				break
			case '8':
				carta.valor = ValorDaCarta.OITO
				break
			case '9':
				carta.valor = ValorDaCarta.NOVE
				break
			case 'T':
				carta.valor = ValorDaCarta.DEZ
				break
			case 'J':
				carta.valor = ValorDaCarta.VALETE
				break
			case 'Q':
				carta.valor = ValorDaCarta.RAINHA
				break
			case 'K':
				carta.valor = ValorDaCarta.REI
				break
			case 'A':
				carta.valor = ValorDaCarta.ACE
				break
		}

		return carta
	}

	static Carta obterNaipe(Carta carta, char naipeString){
		switch (naipeString){
			case 'S':
				carta.naipe = NaipeDaCarta.ESPADAS
				break
			case 'H':
				carta.naipe = NaipeDaCarta.COPAS
				break
			case 'D':
				carta.naipe = NaipeDaCarta.OUROS
				break
			case 'C':
				carta.naipe = NaipeDaCarta.PAUS
				break
		}

		return carta
	}
}
