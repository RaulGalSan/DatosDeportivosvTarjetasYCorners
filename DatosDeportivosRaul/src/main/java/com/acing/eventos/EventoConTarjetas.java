package com.acing.eventos;

import java.util.Collection;

public interface EventoConTarjetas extends LocalContraVisitante{

	static String getFormatoTarjeta() {
		return null;
	}
	
	// Metodos declarados en esta Interface.
	
	Collection<TarjetasAmarillas> getTarjetasAmarillas();
	Collection<TarjetasRojas> getTarjetasRojas();
	
	int getTarjetasAmarillasParticipante(Participante participante);
	int getTarjetasRojasParticipante(Participante participante);
	
	
	public void addTarjetasAmarillas(int tarjetasAmarillasLocal, int tarjetasAmarillasVisitante);
	
	public void addTarjetasRojas(int tarjetasRojasLocal, int tarjetasRojasVisitante);
	
	String getResultadoTarjetas();
	
}
