package com.acing.app;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.xml.ws.FaultAction;

import com.acing.eventos.Evento;
import com.acing.eventos.EventoDAO;
import com.acing.eventos.EventoImpl;
import com.acing.eventos.Gol;
import com.acing.eventos.Partido;
import com.acing.iu.EjemploJFrame;
import com.acing.serial.SerializadorCSV;
import com.acing.serial.SerializadorJson;
// RAUL
public class App {
	
		EventoDAO eventoDAO;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("FUNCIONA CORRECTAMENTE DESDEAPP - 6 Marzo 2019");
		Collection<? extends Evento> eventos;
		
		String rutaCSV="datos/SP1.csv";
		String rutaJson="datos/eventos.json";
		
		App app = new App();		
		app.eventoDAO = new SerializadorCSV(rutaCSV);

		// 1º.- LEER DESDE EL CSV, ejecuta el getEventos del SerializadorCSV.		
		eventos = app.eventoDAO.getEventos();
		
		for (Evento evento : eventos) {
			System.out.println(evento);
		}
		
		// 2º.- Convertir Eventos a JSON.
		
		app.eventoDAO = new SerializadorJson(rutaJson);
		app.eventoDAO.guardarEventos(eventos.toArray(new Partido[] {}));
		
		// 3º.- Leer desde el .json, ejecuta el getEventos del SerializadorJSON.
		eventos = app.eventoDAO.getEventos();
		
//		for (Evento evento : eventos) {
//			System.out.println(evento);
//		}
		
		eventos.stream().forEach(d -> System.out.println(d));
		
		// FALTA POR PROBAR.
		// Uso de los lambda
		

//		eventos.stream().filter(e1 -> e1.getResultado().equals("0-0"))
//		.map(e2 -> {String texto = e2.getFecha().toString();
//					texto += " " + e2.getResultado();
//					return texto;
//					});
//		
		
//		EjemploJFrame frame = new EjemploJFrame();
//		frame.mostrarPartido((Partido) ((List)eventos).get(0));
//		frame.setVisible(true);
		
		
	}

}
