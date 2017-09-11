package br.com.zg.pokerhand.test

import br.com.zg.pokerhand.model.Carta
import br.com.zg.pokerhand.model.ConversorStringToMao
import br.com.zg.pokerhand.model.Mao
import br.com.zg.pokerhand.model.NaipeDaCarta
import br.com.zg.pokerhand.model.ValorDaCarta

class Main {

	static void main(String[] args) {

		ConversorStringToMao conversorStringToMao = new ConversorStringToMao()

		Mao mao = new Mao()
		Mao mao1 = new Mao()

		mao = (conversorStringToMao.obterMao("2S 8D 4S TS 6H"))
		mao1 = (conversorStringToMao.obterMao("2S 2D 4S 5S 7H"))

		mao.classificaMao()
		mao1.classificaMao()

		println(mao.categoria > mao1.categoria)





	}
}
