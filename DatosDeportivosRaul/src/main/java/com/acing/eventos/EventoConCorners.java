package com.acing.eventos;

import java.util.Collection;

public interface EventoConCorners extends LocalContraVisitante {

	static String getFormatoCorner() {
		return null;
	}
	
	// Metodos declarados en esta Interface.
	
	Collection<Corner> getCorners();
	
	int getCornersParticipante(Participante participante);
	
	public void addCorners(int cornersLocal, int cornersVisitante);

	String getResultadoCorners();
	
}
