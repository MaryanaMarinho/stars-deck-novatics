package com.maryana.starsdeck.controller;

import com.maryana.starsdeck.dto.EventDTO;
import com.maryana.starsdeck.dto.UserDTO;
import com.maryana.starsdeck.model.Event;
import com.maryana.starsdeck.model.User;
import com.maryana.starsdeck.service.EventService;
import com.maryana.starsdeck.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService service;

    private final EventService eventService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {

        List<User> userList = service.findAll();

        List<UserDTO> userDTOList = userList.stream().map(UserDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(userDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {

        User obj = service.findById(id);

        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO userDTO) {

        User user = service.insert(userDTO.getUserName());

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body((new UserDTO(user)));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/events")
    public ResponseEntity<Void> insertEvent(@RequestBody EventDTO eventDTO, @PathVariable String id) {

        Event event = eventService.fromDTO(eventDTO);

        User user = service.findById(id);

        service.update(user, event);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(event.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
