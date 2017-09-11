package br.com.zg.pokerhand.model

enum ValorDaCarta {

	DOIS(2),
	TRES(3),
	QUATRO(4),
	CINCO(5),
	SEIS(6),
	SETE(7),
	OITO(8),
	NOVE(9),
	DEZ(10),
	VALETE(11),
	RAINHA(12),
	REI(13),
	ACE(14)

	int valorNum

	ValorDaCarta(int valorNum) {
		this.valorNum = valorNum
	}
}