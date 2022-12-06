package br.com.advanse.eventsapi.application.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventDTO(
        UUID id,
        String title,
        String content,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}