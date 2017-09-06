package br.com.zg.provaestagio.model

class Portao {

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
