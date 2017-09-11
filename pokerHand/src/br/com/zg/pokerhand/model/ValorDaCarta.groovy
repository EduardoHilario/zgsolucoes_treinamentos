package br.com.zg.pokerhand.model

enum ValorDaCarta {

	DOIS('2' as char),
	TRES('3' as char),
	QUATRO('4' as char),
	CINCO('5' as char),
	SEIS('6' as char),
	SETE('7' as char),
	OITO('8' as char),
	NOVE('9' as char),
	DEZ('T' as char),
	VALETE('J' as char),
	RAINHA('Q' as char),
	REI('K' as char),
	ACE('A' as char)

	char valorCaractere

	ValorDaCarta(char string) {
		this.valorCaractere = string
	}

}