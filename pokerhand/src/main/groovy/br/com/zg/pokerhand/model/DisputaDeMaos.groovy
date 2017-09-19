package br.com.zg.pokerhand.model

class DisputaDeMaos {


	static Resultado compare(Mao mao1, Mao mao2) {

		if(mao1.categoria == mao2.categoria){

			for (int i = 0; i < listeCartas(mao1).valor.size(); i++) {
				if (listeCartas(mao1).valor.get(i).first() == listeCartas(mao2).valor.get(i).first()) {
					continue
				}else if(listeCartas(mao1).valor.get(i).first() > listeCartas(mao2).valor.get(i).first()){
					return Resultado.WIN
				}else{
					return Resultado.LOSS
				}
			}
		}else{
			return mao1.categoria > mao2.categoria ? Resultado.WIN : Resultado.LOSS
		}
		return Resultado.DRAW
	}


	static List<List<Carta>> listeCartas(Mao mao) {
		List<List<Carta>> grupoDeCarta = mao.cartas.groupBy { it.valor }.values().findAll { it.size() > 1 }.asList().reverse()
		mao.cartas.groupBy { it.valor }.values().findAll { it.size() == 1 }.asList().reverse().each {
			grupoDeCarta << it
		}
		return grupoDeCarta
	}

}
