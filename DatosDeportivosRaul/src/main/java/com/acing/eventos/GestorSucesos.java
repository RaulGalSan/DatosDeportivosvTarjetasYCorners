package com.acing.eventos;

import java.util.Collection;
import java.util.stream.Collectors;

public interface GestorSucesos<T extends Suceso> extends Evento{

	
	// Metodo default (solo accesible por clases que estan en el mismo paquete), 
	// que devuelve una Coleccion de Sucesos cualquiera que sea.
	default <T extends Suceso> Collection<T> getSucesosGestionados(Class<T> tipo) {		
		return (Collection<T>) getSucesos().stream().filter( 
				               s -> s.getClass().isAssignableFrom(tipo)).
							   collect(Collectors.toList());
	}
	
	// Devuelve el numero de sucesos(del tipo que sea) del Participante que le pasamos.
	default <T extends Suceso> int getSucesosParticipante(Participante participante) {
		return (int) getSucesos().stream().filter(
					 s -> s.getParticipante().equals(participante)).count();
	}

	// Metodo que añade un Suceso del tipo que sea en la Colección de Sucesos.
	default <T extends Suceso> void addSuceso(T suceso) {
		System.out.println("SUCESO CREADO");
		getSucesos().add(suceso);
	}
	
	// Método que añade un Suceso del tipo que sea a un Participante concreto que le pasamos.
	default <T extends Suceso> void addSuceso(Class<T> tipo, Participante participante) {
		addSucesos(tipo, 1, participante);
		
	}
	
	// Metodo que añade un numero x de Sucesos de un tipo y de un Participante.
	default <T extends Suceso> void addSucesos(Class<T> tipo, int numero, Participante participante) {
		System.out.println("El tipo de suceso es: " + tipo + "el total de sucesos es: " + numero + 
				" el equipo participante de los sucesos es: " + participante);
		for (int i = 0; i < numero; i++) {
			T suceso;
			try {
				suceso = tipo.newInstance();
				suceso.setParticipante(participante);
				addSuceso(suceso);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}			
		}
	}
	
	
}
