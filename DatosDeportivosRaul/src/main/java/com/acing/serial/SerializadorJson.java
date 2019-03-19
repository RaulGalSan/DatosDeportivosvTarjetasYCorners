package com.acing.serial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.acing.eventos.Evento;
import com.acing.eventos.EventoDAO;
import com.acing.eventos.EventoImpl;
import com.acing.eventos.Partido;
import com.esotericsoftware.jsonbeans.Json;

import es.lanyu.commons.tiempo.Datable;

public class SerializadorJson implements EventoDAO {
	
	private final String ruta;
	Json json;
	
	
	public SerializadorJson(Json json, String ruta) {
		// TODO Auto-generated constructor stub
		this.ruta=ruta;
		this.json=json;
	}

	public SerializadorJson(String ruta) {
		this(new Json(), ruta);
	}




	@Override
	public Collection<? extends Partido> getEventos() {
		// TODO Auto-generated method stub
		return getEventosFromJson(json,ruta);
	}



	@Override
	public Collection<? extends Evento> getEventos(Date fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	// (EventoImpl... eventos): Soporta que puedas pasar 0, 1 o más argumentos 
	// de tipo EventoImpl solamente.
	public <T extends EventoImpl> int guardarEventos(EventoImpl... eventos) {
		return guardarColeccionAJsonPorLineas(json, ruta, eventos);
	}

	
	private static int guardarColeccionAJsonPorLineas(Json json, String ruta, EventoImpl[] eventos) {
			int numeroEventosGuardados=0;
			try (BufferedWriter writer = new BufferedWriter(
										 new OutputStreamWriter(
										 new FileOutputStream(ruta), "UTF-8"))){	
				
				for (Datable evento : eventos) {
					writer.write(json.toJson(evento));
					numeroEventosGuardados++;
					writer.newLine();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		
		return numeroEventosGuardados;
	}


	private Collection<? extends Partido> getEventosFromJson(Json json, String ruta) {
		Collection<Partido> eventosLeidos = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(
									 new InputStreamReader(
									 new FileInputStream(ruta), "UTF-8"))){
			String linea;
			while ((linea = reader.readLine()) != null) {
				eventosLeidos.add(json.fromJson(Partido.class, linea));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return eventosLeidos;
	}

	private static void guardarStringEnFichero(String cadena, String ruta) {
		try (BufferedWriter writer = new BufferedWriter( 
									 new OutputStreamWriter(
									 new FileOutputStream(ruta), "UTF-8"))){
			writer.write(cadena);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	public <T extends EventoImpl> EventoImpl borrarEvento(EventoImpl evento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends EventoImpl> boolean actualizarEvento(EventoImpl evento) {
		// TODO Auto-generated method stub
		return false;
	}
	


}
