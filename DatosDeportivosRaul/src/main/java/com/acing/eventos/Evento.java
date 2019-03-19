package com.acing.eventos;

import java.util.Collection;

import es.lanyu.commons.tiempo.Datable;

public interface Evento extends Datable {

	Collection<Suceso> getSucesos();
	String getResultado();
	
	
// Implementado en el interfaz GestorSucesos.
//	default void addSucesos(Suceso suceso) {
//		getSucesos().add(suceso);
//	}
 }
