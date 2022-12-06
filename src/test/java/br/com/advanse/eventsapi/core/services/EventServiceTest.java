package br.com.advanse.eventsapi.core.services;

import br.com.advanse.eventsapi.core.models.Event;
import br.com.advanse.eventsapi.core.repositories.EventRepository;
import br.com.advanse.eventsapi.resolvers.EventParameterResolver;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@ExtendWith(EventParameterResolver.class)
class EventServiceTest {
    @Mock
    EventRepository eventRepositoryMock;
    EventService sut;

    @BeforeEach
    void setup(){
        this.sut = new EventServiceImpl(this.eventRepositoryMock);
    }

    @Test
    @DisplayName("Should call event repository just one time")
    void should_call_repository_just_one_time(Event event){
        int expectedTimes = 1;

        this.sut.save(event);

        verify(this.eventRepositoryMock, times(expectedTimes)).save(any());
    }
}