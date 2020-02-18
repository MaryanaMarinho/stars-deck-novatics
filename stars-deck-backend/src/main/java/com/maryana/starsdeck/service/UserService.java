package com.maryana.starsdeck.service;

import com.maryana.starsdeck.client.GithubClient;
import com.maryana.starsdeck.client.GithubUserResponse;
import com.maryana.starsdeck.dto.UserDTO;
import com.maryana.starsdeck.model.Event;
import com.maryana.starsdeck.model.User;
import com.maryana.starsdeck.repository.UserRepository;
import com.maryana.starsdeck.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    private final GithubClient githubClient;

    public List<User> findAll() {
        return repository.findAllByOrderByPointsDesc();
    }

    public User findById(String id) {

        Optional<User> user = repository.findById(id);

        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(String githubUserName) {

        User user = repository.findByUserName(githubUserName);

        if (isNull(user)) {

            GithubUserResponse githubUserResponse = githubClient.getUser(githubUserName);

            User newUser = fromGithub(githubUserResponse);

            return repository.insert(newUser);
        }

        return user;
    }

    public void delete(String id) {

        findById(id);

        repository.deleteById(id);
    }

    public User update(User user, Event event) {

        User newUser = findById(user.getId());
        updateData(newUser, event);

        return repository.save(newUser);
    }

    private void updateData(User newUser, Event event) {

        newUser.getEvents().add(event);
        newUser.setPoints(newUser.getPoints() + event.getEventType().getPoints());
        newUser.setEvents(newUser.getEvents());
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getUserName(),
                userDTO.getBio(),
                userDTO.getAvatarUrl(),
                userDTO.getPoints(),
                userDTO.getEvents());
    }

    public User fromGithub(GithubUserResponse githubUserResponse) {
        List<Event> eventList = new ArrayList<>();
        return new User(
                githubUserResponse.getName(),
                githubUserResponse.getUserName(),
                githubUserResponse.getBio(),
                githubUserResponse.getAvatarUrl(),
                0,
                eventList);
    }

}
