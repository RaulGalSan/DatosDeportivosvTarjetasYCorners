package com.acing.eventos;

public class Suceso {

	Participante participante;

	
	public Suceso() {
		
	};
	
	public Suceso(Participante participante) {
		
		this.participante=participante;
	}
	

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}	

	
}
