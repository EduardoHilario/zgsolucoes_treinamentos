package br.com.zg.pokerhand.model

class Mao {

	List<Carta> cartas = new ArrayList<Carta>()
	Categoria categoria


	@Override
	public String toString() {
		return "Mao{" +
				"cartas=" + cartas +
				", categoria=" + categoria +
				'}';
	}
}
