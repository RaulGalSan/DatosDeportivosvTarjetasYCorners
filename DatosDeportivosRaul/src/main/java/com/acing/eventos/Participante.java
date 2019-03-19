package com.acing.eventos;

import es.lanyu.commons.identificable.AbstractNombrable;

public class Participante extends AbstractNombrable {

	
	
	public Participante() {
		
	}
	
	
	public Participante(String nombre) {		
		setIdentificador(nombre);
		setNombre(nombre);
	}


	@Override
	public String toString() {
		return nombre;
	}



	
	
}
