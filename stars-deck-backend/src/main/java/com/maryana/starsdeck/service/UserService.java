package com.maryana.starsdeck.service;

import com.maryana.starsdeck.client.GithubClient;
import com.maryana.starsdeck.client.GithubUserResponse;
import com.maryana.starsdeck.dto.UserDTO;
import com.maryana.starsdeck.model.User;
import com.maryana.starsdeck.repository.UserRepository;
import com.maryana.starsdeck.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    private final GithubClient githubClient;

    public List<User> findAll() {
        return repository.findAll();
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

    public User update(User user) {

        User newUser = findById(user.getId());
        updateData(newUser, user);

        return repository.save(newUser);
    }

    private void updateData(User newUser, User user) {
        newUser.setPoints(newUser.getPoints() + user.getPoints());
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getUserName(),
                userDTO.getBio(),
                userDTO.getAvatarUrl(),
                userDTO.getPoints());
    }

    public User fromGithub(GithubUserResponse githubUserResponse) {
        return new User(
                githubUserResponse.getName(),
                githubUserResponse.getUserName(),
                githubUserResponse.getBio(),
                githubUserResponse.getAvatarUrl(),
                0);
    }

}
