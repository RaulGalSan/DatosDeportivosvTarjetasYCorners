package com.acing.eventos;

public class TarjetasAmarillas extends Tarjetas {

	String forma;
	
	
	public TarjetasAmarillas() {
		
	}
	
	
	public TarjetasAmarillas(int minuto, Participante participante, String forma) {
		super(minuto,participante);
		this.forma = forma;
	}


	public String getForma() {
		return forma;
	}


	@Override
	public String toString() {
		return "TarjetasAmarillas [forma=" + getForma() + ", participante=" + getParticipante() + "]";
	}
	
	
}
