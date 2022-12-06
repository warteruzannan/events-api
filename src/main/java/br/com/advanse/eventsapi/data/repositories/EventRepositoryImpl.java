package br.com.advanse.eventsapi.data.repositories;

import br.com.advanse.eventsapi.core.models.Event;
import br.com.advanse.eventsapi.core.repositories.EventRepository;
import br.com.advanse.eventsapi.data.entities.EventEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class EventRepositoryImpl implements EventRepository {
    private final DataEventRepository eventRepositoryJPA;

    public EventRepositoryImpl(final DataEventRepository eventRepositoryJPA){
        this.eventRepositoryJPA = eventRepositoryJPA;
    }
    @Override
    public Event save(Event event) {
        EventEntity eventEntity = new EventEntity();
        BeanUtils.copyProperties(event, eventEntity);
        var savedEvent = this.eventRepositoryJPA.save(eventEntity);
        event.setId(savedEvent.getId());
        return event;
    }

    @Override
    public Collection<Event> list() {
        return this.eventRepositoryJPA.findAll().stream().map(eventEntity -> {
            Event event = new Event();
            BeanUtils.copyProperties(eventEntity, event);
            return event;
        }).toList();
    }
}