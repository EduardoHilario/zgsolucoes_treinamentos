package br.com.zg.provaestagio.model

class Controle {

	private def portao = new Portao()
	def retorno

	// Defina também os tipos nos parâmetros de métodos e construtores
	Controle(portao) {
		this.portao = portao
	}


	def executeComando(comando) {

		for (c in comando) {
			switch (c) {
				case 'P':
					pressione()
					break
				case 'O':
					obstaculo()
					break
				case '.':
					manter(c)
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
				manter('P')
				break
			case Status.PARADO:
				if (portao.getUltimoStatus().equals(Status.ABRINDO)) {
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
					def r = retorno.charAt(retorno.length() - 1)
					def rNumerico = Integer.parseInt(String.valueOf(r))
					rNumerico++
					retorno += rNumerico
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
				def r = retorno.charAt(retorno.length() - 1)
				def rNumerico = Integer.parseInt(String.valueOf(r))
				rNumerico--
				retorno += rNumerico
				portao.setStatus(Status.FECHANDO)
		}
	}

	void manter(c) {

		if (retorno == null) {
			retorno = "0"
		} else {
			def r = retorno.charAt(retorno.length() - 1)
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
					retorno += retorno.charAt(retorno.length() - 1)

			}
		}
	}

}
