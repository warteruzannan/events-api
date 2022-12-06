package br.com.advanse.eventsapi.core.services;

import br.com.advanse.eventsapi.core.models.Event;
import br.com.advanse.eventsapi.core.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EventServiceImpl implements EventService{
    private final EventRepository eventRepository;

    public EventServiceImpl(final EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    @Override
    public Event save(Event event) {
        return this.eventRepository.save(event);
    }

    @Override
    public Collection<Event> list() {
        return this.eventRepository.list();
    }
}