package br.com.zg.pokerhand.model

enum NaipeDaCarta {

	ESPADAS('S' as char),
	COPAS('H' as char),
	OUROS('D' as char),
	PAUS('C' as char)

	char naipeCaractere

	NaipeDaCarta(char string) {
		this.naipeCaractere = string
	}
}
