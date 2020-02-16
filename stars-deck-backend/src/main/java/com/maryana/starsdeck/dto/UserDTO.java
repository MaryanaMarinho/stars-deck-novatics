package com.maryana.starsdeck.dto;

import com.maryana.starsdeck.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

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

    public UserDTO(User userObj) {
        this.id = userObj.getId();
        this.name = userObj.getName();
        this.userName = userObj.getUserName();
        this.bio = userObj.getBio();
        this.avatarUrl = userObj.getAvatarUrl();
        this.points = userObj.getPoints();
    }
}
