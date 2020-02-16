package com.maryana.starsdeck.controller;

import com.maryana.starsdeck.dto.EventDTO;
import com.maryana.starsdeck.model.Event;
import com.maryana.starsdeck.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/events")
public class EventController {

    private final EventService service;

    @GetMapping
    public ResponseEntity<List<EventDTO>> findAll() {

        List<Event> eventList = service.findAll();

        List<EventDTO> eventDTOList = eventList.stream().map(EventDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(eventDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> findById(@PathVariable String id) {

        Event event = service.findById(id);

        return ResponseEntity.ok().body(new EventDTO(event));
    }
}
