package br.com.advanse.eventsapi.core.services;

import br.com.advanse.eventsapi.core.models.Event;

import java.util.Collection;

public interface EventService {
    public Event save(Event event);
    public Collection<Event> list();
}