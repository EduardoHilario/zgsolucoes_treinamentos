package br.com.zg.pokerhand.model

class Carta {

	ValorDaCarta valor
	NaipeDaCarta naipe

	ValorDaCarta getValor() {
		return valor
	}

	void setValor(ValorDaCarta valor) {
		this.valor = valor
	}

	NaipeDaCarta getNaipe() {
		return naipe
	}

	void setNaipe(NaipeDaCarta naipe) {
		this.naipe = naipe
	}

	@Override
	public String toString() {
		return "Carta{" +
				"valor=" + valor +
				", naipe=" + naipe +
				'}';
	}
}