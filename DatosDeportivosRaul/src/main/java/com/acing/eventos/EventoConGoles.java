package com.acing.eventos;

import java.util.Collection;

public interface EventoConGoles extends LocalContraVisitante {

	// Metodo estatico declarado en esta Interface.
	
	static String getFormatoGoles() {
		return null;
	}
	
	// Metodos declarados en esta Interface.
	
	Collection<Gol> getGoles();
	
	int getGolesParticipante(Participante participante);
	
	default void addGoles(int numGolesLocal, int numGolesVisitante) {
		
	};
	
	String getResultado();
	
}
