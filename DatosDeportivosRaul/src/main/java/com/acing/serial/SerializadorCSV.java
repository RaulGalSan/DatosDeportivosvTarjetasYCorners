package com.acing.serial;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.acing.eventos.Corner;
import com.acing.eventos.Evento;
import com.acing.eventos.EventoDAO;
import com.acing.eventos.EventoImpl;
import com.acing.eventos.Gol;
import com.acing.eventos.Participante;
import com.acing.eventos.Partido;
import com.acing.eventos.Suceso;
import com.acing.eventos.TarjetasAmarillas;
import com.acing.eventos.TarjetasRojas;
// RAUL
public class SerializadorCSV implements EventoDAO{
	
	private final String ruta;
	
	// Constructor del Serializador con parametro ruta.
	public SerializadorCSV(String ruta) {
		// TODO Auto-generated constructor stub
		this.ruta = ruta;
	}

	
	// Metodo getEventos
	
	public static Collection<Partido> getEventos(String rutaArchivo){
		Collection<Partido> eventosLeidos = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(rutaArchivo), "UTF-8"))){
				// Leemos la primera linea del fichero CSV.
				String linea = reader.readLine(); 
				// Mientras la linea leida sea distinto de nulo.
				while ((linea = reader.readLine()) != null) {
					eventosLeidos.add(deserializarEvento(linea));					
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
		for (Partido partido : eventosLeidos) {
			System.out.println(partido);
		}
		
		return eventosLeidos;
	}
	
	private static Partido deserializarEvento(String linea) throws ParseException {
		String[] campos = linea.split(",");
		String fechaString = campos[1];
		String localString = campos[2];
		String visitanteString = campos[3];
		String golesLocalString = campos[4];
		String golesVisitanteString = campos[5];
		String cornersLocalString = campos[16];
		String cornersVisitanteString = campos[17];
		String tarjetasAmarillasLocalString = campos[18];
		String tarjetasAmarillasVisitanteString = campos[19];
		String tarjetasRojasLocalString = campos[20];
		String tarjetasRojasVisitanteString = campos[21];
				
		SimpleDateFormat sdFormat = new SimpleDateFormat("dd/MM/yy");
			
		Date fecha = sdFormat.parse(fechaString);
		Participante local = new Participante(localString);
		Participante visitante = new Participante(visitanteString);
		int golesLocal = Integer.parseInt(golesLocalString);
		int golesVisitante = Integer.parseInt(golesVisitanteString);
		int cornersLocal = Integer.parseInt(cornersLocalString);
		int cornersVisitante = Integer.parseInt(cornersVisitanteString);
		int tarjetasAmarillasLocal = Integer.parseInt(tarjetasAmarillasLocalString);		
		int tarjetasAmarillasVisitante = Integer.parseInt(tarjetasAmarillasVisitanteString);
		int tarjetasRojasLocal = Integer.parseInt(tarjetasRojasLocalString);
		int tarjetasRojasVisitante = Integer.parseInt(tarjetasRojasVisitanteString);	
		

		System.out.println("TarjetasAmarillaLocal: " + tarjetasAmarillasLocal + " TarjetasAmarillasVisitante: " + tarjetasAmarillasVisitante + "\n");
		System.out.println("TarjetasRojasLocal: " + tarjetasRojasLocal + " TarjetasRojasVisitante: " + tarjetasRojasVisitante + "\n");
		System.out.println("CornersLocal: " + cornersLocal + " CornersVisitante: " + cornersVisitante + "\n");		
		
		Partido miEvento = new Partido(local, visitante, fecha);
		miEvento.addGoles(golesLocal, golesVisitante);
		miEvento.addTarjetasAmarillas(tarjetasAmarillasLocal, tarjetasAmarillasVisitante);
		miEvento.addTarjetasRojas(tarjetasRojasLocal, tarjetasRojasVisitante);
		miEvento.addCorners(cornersLocal, cornersVisitante);
		
		System.out.println("Acabo de crear un partido");
//		addGoles(golesLocal,local,miEvento);
//		addGoles(golesVisitante, visitante, miEvento);		
	
////		Gol suceso = (Gol) new Suceso();
////		System.out.println("El tipo de suceso es de: " + suceso.getClass());
////		miEvento.addSucesos(suceso.getClass(), golesLocal, local);
//		addGoles(golesVisitante, visitante, miEvento);
////		miEvento.addSucesos(suceso.getClass(), golesVisitante, visitante);
		
//		Corner sucesoCorner = (Corner) new Suceso();
//		miEvento.addSucesos(sucesoCorner.getClass(), cornersLocal, local);
//		miEvento.addSucesos(sucesoCorner.getClass(), cornersVisitante, visitante);
//
//		TarjetasAmarillas sucesoTAmarilla = (TarjetasAmarillas) new Suceso();
//		
//		miEvento.addSucesos(sucesoTAmarilla.getClass(), tarjetasAmarillasLocal, local);
//		miEvento.addSucesos(sucesoTAmarilla.getClass(), tarjetasAmarillasVisitante, visitante);
//
//		TarjetasRojas sucesoTRoja = (TarjetasRojas) new Suceso();
//		miEvento.addSucesos(sucesoTRoja.getClass(), tarjetasRojasLocal, local);
//		miEvento.addSucesos(sucesoTRoja.getClass(), tarjetasRojasVisitante, visitante);
		
		
		return miEvento;
	}


//	private static void addGoles(int numeroGoles, Participante equipo, Partido miEvento) {
//		// TODO Auto-generated method stub
//		for (int i = 0; i < numeroGoles; i++) {
//			Suceso gol = new Suceso();
//			gol.setParticipante(equipo);			
//			miEvento.addSuceso(gol);
//		}
//	}


	// Metodo sobreescrito de EventoDAO que llama al metodo estátio de la 
	// Clase Serializador CSV.
	@Override
	public Collection<? extends Evento> getEventos() {		
		return getEventos(ruta); 
	}

	@Override
	public Collection<? extends Evento> getEventos(Date fecha) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public <T extends EventoImpl> int guardarEventos(EventoImpl... eventos) {
		// TODO Auto-generated method stub
		return 0;
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
