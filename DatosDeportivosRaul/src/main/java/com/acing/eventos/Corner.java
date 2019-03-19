package com.acing.eventos;

public class Corner extends Suceso {

	private int minuto;

	public Corner() {
		
	}
	
	public Corner(int minuto, Participante participanteCorner) {
		super(participanteCorner);
		this.minuto = minuto;
	}
	
	
	public Participante getParticipanteCorner() {
		
		return this.getParticipante();
	}

	public int getMinuto() {
		return minuto;
	}
	
	
	
	
	
}
