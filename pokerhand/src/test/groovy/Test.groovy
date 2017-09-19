

import br.com.zg.pokerhand.model.Categoria
import br.com.zg.pokerhand.model.DisputaDeMaos
import br.com.zg.pokerhand.model.Mao
import br.com.zg.pokerhand.model.Resultado
import spock.lang.Specification
import spock.lang.Unroll

class Test extends Specification {
	@Unroll
	def "Testando desempates de carta alta"(){
		given:
		DisputaDeMaos comparaMaos = new DisputaDeMaos()
		Mao mao1 = new Mao(mao1String)
		Mao mao2 = new Mao(mao2String)

		expect:
		resultado == comparaMaos.compare(mao1,mao2)

		where:

		mao1String 		 | mao2String 		|| resultado
		"2C 8S 4S 5H TD" | "TC 3H 4C 8H 9C" || Resultado.LOSS
		"2C 3C 4S 5H 6D" | "3C 4H 5C 6H 7C" || Resultado.LOSS
		"2C 3C 4S 5H 6D" | "3C 4H 5C 6H 7C" || Resultado.LOSS






	}
	@Unroll
	def "Verifica se a primeira mao ganha ou empata com a segunda"(){
		given:
		DisputaDeMaos comparaMaos = new DisputaDeMaos()
		Mao mao1 = new Mao(mao1String)
		Mao mao2 = new Mao(mao2String)

		expect:
		resultado == comparaMaos.compare(mao1,mao2)

		where:

		mao1String 		 | mao2String 		|| resultado
		"9C TC JC QC KC" | "9C 9H 5C 5H AC" || Resultado.WIN
		"TC TH 5C 5H KH" | "9C 9H 5C 5H AC" || Resultado.WIN
		"TS TD KC JC 7C" | "JS JC AS KC TD" || Resultado.LOSS
		"7H 7C QC JS TS" | "7D 7C JS TS 6D" || Resultado.WIN
		"5S 5D 8C 7S 6H" | "7D 7S 5S 5D JS" || Resultado.LOSS
		"AS AD KD 7C 3D" | "AD AH KD 7C 4S" || Resultado.LOSS
		"TS JS QS KS AS" | "AC AH AS AS KS" || Resultado.WIN
		"TS JS QS KS AS" | "TC JS QC KS AC" || Resultado.WIN
		"TS JS QS KS AS" | "QH QS QC AS 8H" || Resultado.WIN
		"AC AH AS AS KS" | "TC JS QC KS AC" || Resultado.WIN
		"AC AH AS AS KS" | "QH QS QC AS 8H" || Resultado.WIN
		"TC JS QC KS AC" | "QH QS QC AS 8H" || Resultado.WIN
		"7H 8H 9H TH JH" | "JH JC JS JD TH" || Resultado.WIN
		"7H 8H 9H TH JH" | "4H 5H 9H TH JH" || Resultado.WIN
		"7H 8H 9H TH JH" | "7C 8S 9H TH JH" || Resultado.WIN
		"7H 8H 9H TH JH" | "TS TH TD JH JD" || Resultado.WIN
		"7H 8H 9H TH JH" | "JH JD TH TC 4C" || Resultado.WIN
		"JH JC JS JD TH" | "4H 5H 9H TH JH" || Resultado.WIN
		"JH JC JS JD TH" | "7C 8S 9H TH JH" || Resultado.WIN
		"JH JC JS JD TH" | "TS TH TD JH JD" || Resultado.WIN
		"JH JC JS JD TH" | "JH JD TH TC 4C" || Resultado.WIN
		"4H 5H 9H TH JH" | "7C 8S 9H TH JH" || Resultado.WIN
		"4H 5H 9H TH JH" | "TS TH TD JH JD" || Resultado.LOSS
		"4H 5H 9H TH JH" | "JH JD TH TC 4C" || Resultado.WIN
		"7C 8S 9H TH JH" | "TS TH TD JH JD" || Resultado.LOSS
		"7C 8S 9H TH JH" | "JH JD TH TC 4C" || Resultado.WIN
		"TS TH TD JH JD" | "JH JD TH TC 4C" || Resultado.WIN
		"2S 3H 4D 5H 6D" | "5H 6D 7H 8C 9C" || Resultado.LOSS
		"2S 3H 4H 5H 6D" | "2S 3H 4D 5H 6C" || Resultado.DRAW
		"2H 3H 4H 5H 7H" | "2D 3D 4D 5D 8D" || Resultado.LOSS
		"2S 2H 2D 5H 6D" | "5H 5D 5H 8C 9C" || Resultado.LOSS
		"2H 3H 4H 5H 6H" | "5H 6H 7H 8H 9H" || Resultado.LOSS
		"TH JH QH KH AH" | "TC JC QC KC AC" || Resultado.DRAW
		"TH TH TH TH AS" | "9C 9C 9C 9C 2S" || Resultado.WIN
		"TH TH TH AH AS" | "9C 9C 9C 2C 2S" || Resultado.WIN
		"2H 4H 6H 8H AS" | "3C 5C 6C 8C JS" || Resultado.WIN
		"2H 2H 2H AH AS" | "2C 2C 2C JC JS" || Resultado.WIN
		"2H 2H 5H AH AS" | "2C 2C 6C AC AS" || Resultado.LOSS
		"2H 3C 3D 3S 6H" | "2C 3D 4D 5C 6C" || Resultado.LOSS





	}

	@Unroll
	def "Verifica opções de maos que formam carta alta"() {
		expect:
		resultado == new Mao(maoString).categoria

		where:
		maoString        || resultado
		"3S 8H 9C TD 5D" || Categoria.HIGH_CARD
		"3S 8D 9D TD 5D" || Categoria.HIGH_CARD
	}

	@Unroll
	def "Verifica opções de maos que formam par"() {
		expect:
		resultado == new Mao(maoString).categoria

		where:
		maoString        || resultado
		"9S 2H 9C 3D 5D" || Categoria.PAIR
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
		expect:
		resultado == new Mao(maoString).categoria

		where:
		maoString        || resultado
		"5S 2H 4C 4D 5D" || Categoria.TWO_PAIR
		"2S 2H 4C 5D 4D" || Categoria.TWO_PAIR
		"2S 2H 5C 4D 4D" || Categoria.TWO_PAIR
		"2S 5H 2C 4D 4D" || Categoria.TWO_PAIR
		"5S 2H 2C 4D 4D" || Categoria.TWO_PAIR

	}

	@Unroll
	def "Verifica opções de maos que formam trinca"(){
		expect:
		resultado == new Mao(maoString).categoria

		where:
		maoString        || resultado
		"TS TH TC 3D KD" || Categoria.THREE
		"3S 3H TC 3D KD" || Categoria.THREE
		"3S 3H TC KD 3D" || Categoria.THREE
		"3S TH 3C 3D KD" || Categoria.THREE
		"3S TH 3C KD 3D" || Categoria.THREE
		"3S TH KC 3D 3H" || Categoria.THREE
		"TS 3H 3C 3D KD" || Categoria.THREE
		"TS 3H 3C KD 3D" || Categoria.THREE
		"TS 6H 3C 3D 3D" || Categoria.THREE
		"2H 3H 3D 3S 6H" || Categoria.THREE

	}

	@Unroll
	def "Verifica opções de maos que formam uma sequência"(){
		expect:
		resultado == new Mao(maoString).categoria

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
		expect:
		resultado == new Mao(maoString).categoria

		where:
		maoString        || resultado
		"3H 2H 7H KH 4H" || Categoria.FLUSH
		"2C 2C 3C 3C 4C" || Categoria.FLUSH
		"2D 2D 2D 8D 4D" || Categoria.FLUSH
		"AS AS 5S 6S 4S" || Categoria.FLUSH

	}

	@Unroll
	def "Verifica opções de maos que formam full house"(){
		expect:
		resultado == new Mao(maoString).categoria

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
		expect:
		resultado == new Mao(maoString).categoria

		where:
		maoString        || resultado
		"KS KH KC KD 4D" || Categoria.FOUR
		"4S KH 4C 4D 4D" || Categoria.FOUR
		"4S 4H KC 4D 4D" || Categoria.FOUR
		"4S 4H 4C KD 4D" || Categoria.FOUR
		"4S 4H 4C 4D KD" || Categoria.FOUR

	}

	@Unroll
	def "Verifica opções de maos que formam uma sequência do mesmo naipe"(){
		expect:
		resultado == new Mao(maoString).categoria

		where:
		maoString        || resultado
		"2H 3H 4H 5H 6H" || Categoria.STRAIGHT_FLUSH
		"3C 4C 5C 6C 7C" || Categoria.STRAIGHT_FLUSH
		"4D 5D 6D 7D 8D" || Categoria.STRAIGHT_FLUSH
		"5S 6S 7S 8S 9S" || Categoria.STRAIGHT_FLUSH

	}

	@Unroll
	def "Verifica opções de maos que formam uma sequência de 10 a As do mesmo naipe"(){
		expect:
		resultado == new Mao(maoString).categoria

		where:
		maoString        || resultado
		"TH JH QH KH AH" || Categoria.ROYAL_FLUSH
		"TC JC QC KC AC" || Categoria.ROYAL_FLUSH
		"TD JD QD KD AD" || Categoria.ROYAL_FLUSH
		"TS JS QS KS AS" || Categoria.ROYAL_FLUSH

	}

}
