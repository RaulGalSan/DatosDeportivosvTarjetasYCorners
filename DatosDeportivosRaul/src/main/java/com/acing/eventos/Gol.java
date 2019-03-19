package com.acing.eventos;

public class Gol extends Suceso {

	private int minuto;
	
	
	public Gol() {
		
	}
	

	public Gol(int minuto, Participante anotador) {
		super(anotador);
		this.minuto = minuto;
		System.out.println("Entrando a crear un Gol");
		
	}
	
	public Participante getParticipanteAnotador() {
		 		
		return this.getParticipante();
	}


	public int getMinuto() {
		return minuto;
	}


	@Override
	public String toString() {
		return "Gol [minuto=" + minuto + ", participante=" + participante + "]";
	}
	
	
}
