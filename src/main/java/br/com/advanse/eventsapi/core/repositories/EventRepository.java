package br.com.advanse.eventsapi.core.repositories;

import br.com.advanse.eventsapi.core.models.Event;

import java.util.Collection;

public interface EventRepository {
    public Event save(Event event);
    public Collection<Event> list();
}