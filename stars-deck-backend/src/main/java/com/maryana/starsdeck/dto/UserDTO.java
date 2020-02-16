package com.maryana.starsdeck.dto;

import com.maryana.starsdeck.model.Event;
import com.maryana.starsdeck.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String userName;
    private String bio;
    private String avatarUrl;
    private Integer points;
    private List<Event> events = new ArrayList<>();

    public UserDTO(User userObj) {
        this.id = userObj.getId();
        this.name = userObj.getName();
        this.userName = userObj.getUserName();
        this.bio = userObj.getBio();
        this.avatarUrl = userObj.getAvatarUrl();
        this.points = userObj.getPoints();
        this.events = userObj.getEvents();
    }
}
