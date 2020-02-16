package com.maryana.starsdeck.service;

import com.maryana.starsdeck.dto.EventDTO;
import com.maryana.starsdeck.model.Event;
import com.maryana.starsdeck.repository.EventRepository;
import com.maryana.starsdeck.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EventService {

    private final EventRepository repository;

    public List<Event> findAll() {
        return repository.findAll();
    }

    public Event findById(String id) {
        Optional<Event> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public Event fromDTO(EventDTO eventDTO){
        return new Event(
                eventDTO.getId(),
                eventDTO.getEventType(),
                eventDTO.getDate(),
                eventDTO.getTitle(),
                eventDTO.getComment());
    }
}
