package br.com.zg.pokerhand.test

import br.com.zg.pokerhand.model.Categoria
import br.com.zg.pokerhand.model.ConversorStringToMao
import br.com.zg.pokerhand.model.Mao
import spock.lang.Specification
import spock.lang.Unroll

class TesteConversor extends Specification {

	@Unroll
	def "Verifica opções de maos que formam carta alta"() {
		given:
		ConversorStringToMao conversorStringToMao = new ConversorStringToMao()
		Mao mao = (conversorStringToMao.obterMao(maoString))

		when:
		mao.classificaMao()

		then:
		mao.categoria == resultado

		where:
		maoString        || resultado
		"3S 8H 9C TD 5D" || Categoria.HIGH_CARD
		"3S 8D 9D TD 5D" || Categoria.HIGH_CARD
	}

	@Unroll
	def "Verifica opções de maos que formam par"() {
		given:
		ConversorStringToMao conversorStringToMao = new ConversorStringToMao()
		Mao mao = (conversorStringToMao.obterMao(maoString))

		when:
		mao.classificaMao()

		then:
		mao.categoria == resultado

		where:
		maoString        || resultado
		"3S 3H 9C TD 5D" || Categoria.PAIR
		"3S 9H 3C TD 5D" || Categoria.PAIR
		"3S 9H TC 3D 5D" || Categoria.PAIR
		"3S 9H 5C TD 3D" || Categoria.PAIR
		"9S 3H 3C TD 5D" || Categoria.PAIR
		"9S 3H 5C 3D 6D" || Categoria.PAIR
		"9S 3H 5C TD 3D" || Categoria.PAIR
		"9S 8H 3C 3D TD" || Categoria.PAIR
		"9S 8H 3C TD 3D" || Categoria.PAIR
		"9S 8H TC 3D 3D" || Categoria.PAIR
		"2S 3D 4S 5S 2H" || Categoria.PAIR
	}

	@Unroll
	def "Verifica opções de maos que formam dois pares"(){
		given:
		ConversorStringToMao conversorStringToMao = new ConversorStringToMao()
		Mao mao = (conversorStringToMao.obterMao(maoString))

		when:
		mao.classificaMao()

		then:
		mao.categoria == resultado

		where:
		maoString        || resultado
		"2S 2H 4C 4D 5D" || Categoria.TWO_PAIR
		"2S 2H 4C 5D 4D" || Categoria.TWO_PAIR
		"2S 2H 5C 4D 4D" || Categoria.TWO_PAIR
		"2S 5H 2C 4D 4D" || Categoria.TWO_PAIR
		"5S 2H 2C 4D 4D" || Categoria.TWO_PAIR

	}

	@Unroll
	def "Verifica opções de maos que formam trinca"(){
		given:
		ConversorStringToMao conversorStringToMao = new ConversorStringToMao()
		Mao mao = (conversorStringToMao.obterMao(maoString))

		when:
		mao.classificaMao()

		then:
		mao.categoria == resultado

		where:
		maoString        || resultado
		"3S 3H 3C TD KD" || Categoria.THREE
		"3S 3H TC 3D KD" || Categoria.THREE
		"3S 3H TC KD 3D" || Categoria.THREE
		"3S TH 3C 3D KD" || Categoria.THREE
		"3S TH 3C KD 3D" || Categoria.THREE
		"3S TH KC 3D 3H" || Categoria.THREE
		"TS 3H 3C 3D KD" || Categoria.THREE
		"TS 3H 3C KD 3D" || Categoria.THREE
		"TS 6H 3C 3D 3D" || Categoria.THREE

	}

	@Unroll
	def "Verifica opções de maos que formam uma sequência"(){
		given:
		ConversorStringToMao conversorStringToMao = new ConversorStringToMao()
		Mao mao = (conversorStringToMao.obterMao(maoString))

		when:
		mao.classificaMao()

		then:
		mao.categoria == resultado

		where:
		maoString        || resultado
		"2C 3H 4H 5H 6H" || Categoria.STRAIGHT
		"3H 4C 5H 6H 7H" || Categoria.STRAIGHT
		"4H 5H 6C 7H 8H" || Categoria.STRAIGHT
		"5H 6H 7C 8H 9H" || Categoria.STRAIGHT
		"6H 7H 8C 9H TH" || Categoria.STRAIGHT
		"7H 8C 9H TH JH" || Categoria.STRAIGHT
		"8H 9C TH JH QH" || Categoria.STRAIGHT
		"9H TC JH QH KH" || Categoria.STRAIGHT

	}

	@Unroll
	def "Verifica opções de maos que formam flush"(){
		given:
		ConversorStringToMao conversorStringToMao = new ConversorStringToMao()
		Mao mao = (conversorStringToMao.obterMao(maoString))

		when:
		mao.classificaMao()

		then:
		mao.categoria == resultado

		where:
		maoString        || resultado
		"3H 2H 7H KH 4H" || Categoria.FLUSH
		"2C 2C 3C 3C 4C" || Categoria.FLUSH
		"2D 2D 2D 8D 4D" || Categoria.FLUSH
		"AS AS 5S 6S 4S" || Categoria.FLUSH

	}

	@Unroll
	def "Verifica opções de maos que formam full house"(){
		given:
		ConversorStringToMao conversorStringToMao = new ConversorStringToMao()
		Mao mao = (conversorStringToMao.obterMao(maoString))

		when:
		mao.classificaMao()

		then:
		mao.categoria == resultado

		where:
		maoString        || resultado
		"AS AH AC 4D 4D" || Categoria.FULL_HOUSE
		"2S 2H 4C 2D 4D" || Categoria.FULL_HOUSE
		"2S 2H 4C 4D 2D" || Categoria.FULL_HOUSE
		"2S 4H 2C 2D 4D" || Categoria.FULL_HOUSE
		"2S 4H 4C 2D 4D" || Categoria.FULL_HOUSE

	}

	@Unroll
	def "Verifica opções de maos que formam quadra"(){
		given:
		ConversorStringToMao conversorStringToMao = new ConversorStringToMao()
		Mao mao = (conversorStringToMao.obterMao(maoString))

		when:
		mao.classificaMao()

		then:
		mao.categoria == resultado

		where:
		maoString        || resultado
		"KS 4H 4C 4D 4D" || Categoria.FOUR
		"4S KH 4C 4D 4D" || Categoria.FOUR
		"4S 4H KC 4D 4D" || Categoria.FOUR
		"4S 4H 4C KD 4D" || Categoria.FOUR
		"4S 4H 4C 4D KD" || Categoria.FOUR

	}

	@Unroll
	def "Verifica opções de maos que formam uma sequência do mesmo naipe"(){
		given:
		ConversorStringToMao conversorStringToMao = new ConversorStringToMao()
		Mao mao = (conversorStringToMao.obterMao(maoString))

		when:
		mao.classificaMao()

		then:
		mao.categoria == resultado

		where:
		maoString        || resultado
		"2H 3H 4H 5H 6H" || Categoria.STRAIGHT_FLUSH
		"3C 4C 5C 6C 7C" || Categoria.STRAIGHT_FLUSH
		"4D 5D 6D 7D 8D" || Categoria.STRAIGHT_FLUSH
		"5S 6S 7S 8S 9S" || Categoria.STRAIGHT_FLUSH

	}

	@Unroll
	def "Verifica opções de maos que formam uma sequência de 10 a As do mesmo naipe"(){
		given:
		ConversorStringToMao conversorStringToMao = new ConversorStringToMao()
		Mao mao = (conversorStringToMao.obterMao(maoString))

		when:
		mao.classificaMao()

		then:
		mao.categoria == resultado

		where:
		maoString        || resultado
		"TH JH QH KH AH" || Categoria.ROYAL_FLUSH
		"TC JC QC KC AC" || Categoria.ROYAL_FLUSH
		"TD JD QD KD AD" || Categoria.ROYAL_FLUSH
		"TS JS QS KS AS" || Categoria.ROYAL_FLUSH

	}

	@Unroll
	def "Verifica se a primeira mao é maior que a segunda"(){
		given:
		ConversorStringToMao conversorStringToMao = new ConversorStringToMao()
		Mao mao1 = (conversorStringToMao.obterMao(mao1String))
		Mao mao2 = (conversorStringToMao.obterMao(mao2String))

		when:
		mao1.classificaMao()
		mao2.classificaMao()

		then:
		mao1.categoria > mao2.categoria

		where:

		mao1String 		 | mao2String 		|| resultado
		"9C TC JC QC KC" | "9C 9H 5C 5H AC" || true
		"TC TH 5C 5H KH" | "9C 9H 5C 5H AC" || true
		"7H 7C QC JS TS" | "7D 7C JS TS 6D" || true
		"TS JS QS KS AS" | "AC AH AS AS KS" || true
		"TS JS QS KS AS" | "TC JS QC KS AC" || true
		"TS JS QS KS AS" | "QH QS QC AS 8H" || true
		"AC AH AS AS KS" | "TC JS QC KS AC" || true
		"AC AH AS AS KS" | "QH QS QC AS 8H" || true
		"TC JS QC KS AC" | "QH QS QC AS 8H" || true
		"7H 8H 9H TH JH" | "JH JC JS JD TH" || true
		"7H 8H 9H TH JH" | "4H 5H 9H TH JH" || true
		"7H 8H 9H TH JH" | "7C 8S 9H TH JH" || true
		"7H 8H 9H TH JH" | "TS TH TD JH JD" || true
		"7H 8H 9H TH JH" | "JH JD TH TC 4C" || true
		"JH JC JS JD TH" | "4H 5H 9H TH JH" || true
		"JH JC JS JD TH" | "7C 8S 9H TH JH" || true
		"JH JC JS JD TH" | "TS TH TD JH JD" || true
		"JH JC JS JD TH" | "JH JD TH TC 4C" || true
		"4H 5H 9H TH JH" | "7C 8S 9H TH JH" || true
		"4H 5H 9H TH JH" | "JH JD TH TC 4C" || true
		"7C 8S 9H TH JH" | "JH JD TH TC 4C" || true
		"TS TH TD JH JD" | "JH JD TH TC 4C" || true
		"TH TH TH TH AS" | "9C 9C 9C 9C 2S" || true
		"TH TH TH AH AS" | "9C 9C 9C 2C 2S" || true
		"2H 4H 6H 8H AS" | "3C 5C 6C 8C JS" || true
		"2H 2H 2H AH AS" | "2C 2C 2C JC JS" || true

	}

}
