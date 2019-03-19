package com.acing.eventos;

import java.util.Collection;
import java.util.Date;

public interface EventoDAO {
	Collection<? extends Evento> getEventos();
    Collection<? extends Evento> getEventos(Date fecha);
    <T extends EventoImpl> int guardarEventos(EventoImpl... eventos);
    <T extends EventoImpl> EventoImpl borrarEvento(EventoImpl evento);
    <T extends EventoImpl> boolean actualizarEvento(EventoImpl evento);
}
