package br.com.zg.provaestagio.test

class Test {

	static void main(String[] args) {

		String retorno = "225212220"

		println(lastPlus(retorno))
	}

	static Integer lastPlus(String retorno){
		Integer c = Integer.valueOf(retorno[-1])
		return c+1
	}
}
