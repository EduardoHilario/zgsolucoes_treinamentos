package br.com.zg.provaestagio.model

class Controle {

	Portao portao = new Portao()
	String retorno

	// Defina também os tipos nos parâmetros de métodos e construtores
	Controle(portao) {
		this.portao = portao
	}


	def executeComando(String comando) {

		// usar o .each no lugar no for
		comando.each {

			switch (it) {
				case 'P':
					pressione()
					break
				case 'O':
					obstaculo()
					break
				case '.':
					manter()
					break
				default:
					break
			}
		}

		return retorno
	}

	void pressione() {
		switch (portao.status) {
			case Status.FECHADO:
				abrir()
				break
			case Status.ABRINDO:
			case Status.FECHANDO:
				portao.setStatus(Status.PARADO)
				manter()
				break
			case Status.PARADO:
				if (portao.ultimoStatus.equals(Status.ABRINDO)) {
					abrir()
				} else {
					fechar()
				}
		}
	}

	void obstaculo() {
		if (portao.status.equals(Status.ABRINDO)) {
			fechar()
		} else {
			abrir()
		}
	}

	void abrir() {
		if (retorno == null) {
			retorno = "1"
		} else {
			switch (portao.status) {
				case Status.ABERTO:
					retorno += "5"
					break
				case Status.FECHANDO:
				case Status.ABRINDO:
				case Status.PARADO:
					retorno += incrementeRetorno(retorno)
					break
				default:
					retorno += 1
			}

		}

		portao.setStatus(Status.ABRINDO)
	}

	void fechar() {
		switch (portao.status) {
			case Status.FECHADO:
				retorno += "0"
				break
			case Status.ABRINDO:
			case Status.FECHANDO:
			case Status.PARADO:
				retorno += decrementeRetorno(retorno)
				portao.setStatus(Status.FECHANDO)
		}
	}

	void manter() {

		if (retorno == null) {
			retorno = "0"
		} else {

			char r = retorno[-1]
			switch (portao.status) {
				case Status.ABRINDO:
					if (r == '5') {
						portao.setStatus(Status.ABERTO)
					}
					abrir()
					break
				case Status.FECHANDO:
					if (r == '0') {
						portao.setStatus(Status.FECHADO)
					}
					fechar()
					break
				case Status.FECHADO:
					retorno += "0"
					break
				case Status.ABERTO:
					retorno += "5"
					break
				case Status.PARADO:
					retorno += retorno[-1]

			}
		}
	}

	Integer incrementeRetorno(String retorno) {
		Integer c = Integer.valueOf(retorno[-1])
		return c + 1

	}

	Integer decrementeRetorno(String retorno) {
		Integer c = Integer.valueOf(retorno[-1])
		return c - 1
	}

}
