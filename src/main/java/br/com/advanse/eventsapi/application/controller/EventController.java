package br.com.advanse.eventsapi.application.controller;

import br.com.advanse.eventsapi.application.dtos.EventDTO;
import br.com.advanse.eventsapi.core.models.Event;
import br.com.advanse.eventsapi.core.services.EventService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

import static br.com.advanse.eventsapi.application.configs.ApiConfigs.API_EVENTS_PATH;


@RestController
@RequestMapping(path = API_EVENTS_PATH)
public class EventController {
    private final EventService eventService;

    public EventController(final EventService eventService){
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<EventDTO> create(@RequestBody EventDTO eventDTO){
        Event event = new Event();
        BeanUtils.copyProperties(eventDTO, event);
        this.eventService.save(event);

        return ResponseEntity.ok(eventDTO);
    }

    @GetMapping
    public ResponseEntity<Collection<EventDTO>> list(){
        List<EventDTO> events = this.eventService.list().stream().map(event ->
            new EventDTO(event.getId(), event.getTitle(), event.getContent(), event.getCreatedAt(), event.getUpdatedAt())
        ).toList();

        return ResponseEntity.ok(events);
    }
}