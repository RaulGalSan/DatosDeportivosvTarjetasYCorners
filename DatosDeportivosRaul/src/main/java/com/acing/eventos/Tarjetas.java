package com.acing.eventos;

public abstract class Tarjetas extends Suceso{
	
	private static String color;
	private int minuto;
	
	public Tarjetas() {
		
	}
	
	
	public Tarjetas(int minuto, Participante amonestado) {
		super(amonestado);
		this.minuto = minuto;
	}
	
	
	
}
