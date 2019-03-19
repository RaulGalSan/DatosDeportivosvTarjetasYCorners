package com.acing.eventos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Partido extends EventoImpl implements GestorSucesos<Suceso>, EventoConGoles, EventoConTarjetas, EventoConCorners{

	private final static SimpleDateFormat sdfToString = new SimpleDateFormat("dd/MM/yy HH:mm");
	private Participante local;
	private Participante visitante;
	private String resultado;
	
	public Partido() {};
	
	public Partido(Participante local, Participante visitante, Date fecha) {
		super();
		this.local = local;
		this.visitante = visitante;
		setFecha(fecha);
	}	
	
	
	public Participante getLocal() {
//		Participante local = new Participante();
		return local;
	}

	public Participante getVisitante() {
//		Participante visitante = new Participante();
		return visitante;
	}


	public String getResultado() {
		
		// Otra manera de crear el resultado.
//		long golesLocal = 0; // = getSucesos().stream()
//		.filter(s -> s.getParticipante().equals(local))
//		.count();
		
//		long golesVisitante = 0;
//		for (Suceso s : getSucesos()) {
//			if(s.getParticipante().equals(visitante))
//				golesVisitante++;
//			if(s.getParticipante().equals(local))
//				golesLocal++;
//		}			
		
		long golesLocal = getGoles().stream().filter(s -> s.getParticipante().equals(local)).count();		
		long golesVisitante = getGoles().stream().filter(s -> s.getParticipante().equals(visitante)).count();		
	
		return golesLocal + "-" +golesVisitante;
	}

	@Override
	public String getResultadoTarjetas() {
		long tarjetasAmarillasLocal = getSucesosGestionados(TarjetasAmarillas.class).stream()
							.filter(s -> s.getParticipante().equals(getLocal()))
							.count();
		long tarjetasAmarillasVisitante = getSucesosGestionados(TarjetasAmarillas.class).stream()
				.filter(s -> s.getParticipante().equals(getVisitante()))
				.count();
		
		long tarjetasRojasLocal  = getSucesosGestionados(TarjetasRojas.class).stream()
				.filter(s -> s.getParticipante().equals(getLocal()))
				.count();
		long tarjetasRojasVisitante  = getSucesosGestionados(TarjetasRojas.class).stream()
				.filter(s -> s.getParticipante().equals(getVisitante()))
				.count();
	
		return "Amarillas: " + tarjetasAmarillasLocal + "L - " + tarjetasAmarillasVisitante + 
				"V " + " Rojas: " + tarjetasRojasLocal + "L - " + tarjetasRojasVisitante + "V ";
	}
	
	
	
	

	// Si el suceso es de tipo Gol lo añade a un Collection de Goles y los devuelve.
	@Override
	public Collection<Gol> getGoles() {
		Collection<Gol> golesAux = new ArrayList<>();
		for (Suceso suceso : getSucesos()) {
			if (suceso instanceof Gol) {				
					golesAux.add((Gol) suceso);
			}
		}		
		return golesAux;
	}
	

	// Metodo que devuelve el numero de goles de un Participante. Para ello recorremos todos 
	// los sucesos y aquellos cuyo Participante sea igual al que le pasamos vamos aumentando
	// el contador de numero de goles del Participante. Override de Interfaz Evento con Goles.
	@Override
	public int getGolesParticipante(Participante participante) {
		int golesParticipante = 0;
		
		for (Suceso suceso : getSucesos()) {
			if (suceso.getParticipante().equals(participante)) {
				golesParticipante++;
			}
			
		}		
		return golesParticipante;
	}

	// Metodo que añade los sucesos Gol del equipo local y visitante.
	// Override de Interfaz Evento con Goles.
	@Override
	public void addGoles(int numGolesLocal, int numGolesVisitante) {
		System.out.println("GolesLocal: " + numGolesLocal + " GolesVisitante: " + numGolesVisitante);
//		for (int i = 1; i < numGolesLocal; i++) {
//			Gol golEquipoLocal = new Gol(0,getLocal());
//			addSuceso(golEquipoLocal);			
//		}
//		
//		for (int i = 1; i < numGolesVisitante; i++) {
//			Gol golEquipoVisitante = new Gol(0,getVisitante());
//			addSuceso(golEquipoVisitante);			
//		}
		
		addSucesos(Gol.class, numGolesLocal, getLocal());
		addSucesos(Gol.class, numGolesVisitante, getVisitante());
	}


	
	@Override
	public Collection<TarjetasAmarillas> getTarjetasAmarillas() {
		// TODO Auto-generated method stub
		
		Collection<TarjetasAmarillas> tarjetasAmarillasAux = new ArrayList<>();
		for (Suceso suceso : getSucesos()) {
			if (suceso instanceof TarjetasAmarillas) {				
					tarjetasAmarillasAux.add((TarjetasAmarillas) suceso);
			}
		}		
		return tarjetasAmarillasAux;
	}

	@Override
	public Collection<TarjetasRojas> getTarjetasRojas() {
		// TODO Auto-generated method stub
		Collection<TarjetasRojas> tarjetasRojasAux = new ArrayList<>();
		for (Suceso suceso : getSucesos()) {
			if (suceso instanceof TarjetasRojas) {				
					tarjetasRojasAux.add((TarjetasRojas) suceso);
			}
		}		
		return tarjetasRojasAux;
	}

	@Override
	public int getTarjetasAmarillasParticipante(Participante participante) {
		// TODO Auto-generated method stub
		int tarjetasAmarillasParticipante = 0;
		
		for (Suceso suceso : getSucesos()) {
			if (suceso.getParticipante().equals(participante)) {
				tarjetasAmarillasParticipante++;
			}
			
		}		
		return tarjetasAmarillasParticipante;
	}

	
	@Override
	public int getTarjetasRojasParticipante(Participante participante) {
		// TODO Auto-generated method stub
		int tarjetasRojasParticipante = 0;
		
		for (Suceso suceso : getSucesos()) {
			if (suceso.getParticipante().equals(participante)) {
				tarjetasRojasParticipante++;
			}
			
		}		
		return tarjetasRojasParticipante;
	}

	@Override
	public void addTarjetasAmarillas(int tarjetasAmarillasLocal, int tarjetasAmarillasVisitante) {
		// TODO Auto-generated method stub
//		for (int i = 1; i < tarjetasAmarillasLocal; i++) {
//			TarjetasAmarillas tarjetasAmarillasEquipoLocal = new TarjetasAmarillas(0,getLocal(),"cuadrada");
//			addSuceso(tarjetasAmarillasEquipoLocal);			
//		}
//		
//		for (int i = 1; i < tarjetasAmarillasVisitante; i++) {
//			TarjetasAmarillas tarjetasAmarillasEquipoVisitante = new TarjetasAmarillas(0,getVisitante(),"cuadrada");
//			addSuceso(tarjetasAmarillasEquipoVisitante);			
//		}
		addSucesos(TarjetasAmarillas.class, tarjetasAmarillasLocal, getLocal());
		addSucesos(TarjetasAmarillas.class, tarjetasAmarillasVisitante, getVisitante());
	}
	
	
	@Override
	public void addTarjetasRojas(int tarjetasRojasLocal, int tarjetasRojasVisitante) {
		// TODO Auto-generated method stub
//		for (int i = 1; i < tarjetasRojasLocal; i++) {
//			TarjetasRojas tarjetasRojasEquipoLocal = new TarjetasRojas(0,getLocal(),0);
//			addSuceso(tarjetasRojasEquipoLocal);			
//		}
//		
//		for (int i = 1; i < tarjetasRojasVisitante; i++) {
//			TarjetasRojas tarjetasRojasEquipoVisitante = new TarjetasRojas(0,getVisitante(),0);
//			addSuceso(tarjetasRojasEquipoVisitante);			
//		}
		addSucesos(TarjetasRojas.class, tarjetasRojasLocal, getLocal());
		addSucesos(TarjetasRojas.class, tarjetasRojasVisitante, getVisitante());
	}

	@Override
	public Collection<Corner> getCorners() {
		Collection<Corner> cornersAux = new ArrayList<>();
		for (Suceso suceso : getCorners()) {
			if (suceso instanceof Corner) {
				cornersAux.add((Corner) suceso) ;
			}
		};
		// TODO Auto-generated method stub
				return cornersAux;
	}
		
		

	@Override
	public int getCornersParticipante(Participante participante) {
		// TODO Auto-generated method stub
		int cornersParticipante = 0;
		
		for (Suceso suceso : getSucesos()) {
			if(suceso.getParticipante().equals(participante)) {
				cornersParticipante++;
			}			
		}
		return cornersParticipante;
	}

	
	@Override
	public void addCorners(int cornersLocal, int cornersVisitante) {
		// TODO Auto-generated method stub
		addSucesos(Corner.class, cornersLocal, getLocal());
		addSucesos(Corner.class, cornersVisitante, getVisitante());
	}

	@Override
	public String getResultadoCorners() {
		// TODO Auto-generated method stub
		
		long cornersLocal = getSucesosGestionados(Corner.class).stream()
				.filter(s -> s.getParticipante().equals(getLocal()))
				.count();
		long cornersVisitante = getSucesosGestionados(Corner.class).stream()
				.filter(s -> s.getParticipante().equals(getVisitante()))
				.count();
		return cornersLocal + "L - " + cornersVisitante + "V";
	}	
	
	

	@Override
	public String toString() {
		return "(" + sdfToString.format(getFecha()) + ") " + local + " vs " + visitante 
				+ " => " + getResultado() + " ---TARJETAS--- " + getResultadoTarjetas() + 
				" ---CORNERS--- " + getResultadoCorners();
	}

	
}