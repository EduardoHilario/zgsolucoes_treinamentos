package br.com.zg.pokerhand.test

import br.com.zg.pokerhand.model.Carta
import br.com.zg.pokerhand.model.ConversorStringToMao
import br.com.zg.pokerhand.model.Mao
import br.com.zg.pokerhand.model.ValorDaCarta

class Main {

	static void main(String[] args) {

		ConversorStringToMao conversorStringToMao = new ConversorStringToMao()

		println(conversorStringToMao.obterMao("KS 2H 5C JD TD").toString())


	}
}
