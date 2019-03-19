package com.acing.eventos;

import java.util.ArrayList;
import java.util.Collection;

import es.lanyu.commons.tiempo.DatableImpl;

public abstract class EventoImpl extends DatableImpl implements Evento {

	private Collection<Suceso> sucesos;

	public EventoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Collection<Suceso> getSucesos() {
		if (sucesos == null) {
			
			sucesos = new ArrayList<>();
		}
		
		return sucesos;
	}
	
	
	
	
}
