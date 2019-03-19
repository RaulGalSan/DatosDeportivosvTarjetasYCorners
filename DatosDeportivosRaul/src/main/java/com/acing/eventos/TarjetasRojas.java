package com.acing.eventos;

public class TarjetasRojas extends Tarjetas {

	private int codTarjetaRoja;
	
	public TarjetasRojas() {
		
	}
	
	public TarjetasRojas(int codTarjetaRoja) {
		
		this.codTarjetaRoja = codTarjetaRoja;
	}

	public TarjetasRojas(int minuto, Participante participante, int codTarjetaRoja) {
		super(minuto,participante);
		this.codTarjetaRoja = codTarjetaRoja;
	}
	
	
	public int getCodTarjetaRoja() {
		return codTarjetaRoja;
	}

	@Override
	public String toString() {
		return "TarjetasRojas [codTarjetaRoja=" + codTarjetaRoja + ", participante=" + participante + "]";
	}
	
	
	
	
}
