package br.com.zg.provaestagio.model

class Portao {

	Status status
	Status ultimoStatus

	Portao() {
		this.status = Status.FECHADO
	}


	void setStatus(Status status) {
		this.ultimoStatus = this.status
		this.status = status
	}

}
