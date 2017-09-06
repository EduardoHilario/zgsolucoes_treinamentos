package br.com.zg.provaestagio.model

class Portao {

	//Substituir def  por tipo apropriado
	private def status
	def ultimoStatus

	Portao() {
		this.status = Status.FECHADO
	}


	void setStatus(status) {
		this.ultimoStatus = this.status
		this.status = status
	}

}
