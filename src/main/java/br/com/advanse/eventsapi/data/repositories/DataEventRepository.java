package br.com.advanse.eventsapi.data.repositories;

import br.com.advanse.eventsapi.data.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DataEventRepository extends JpaRepository<EventEntity, UUID> {

}