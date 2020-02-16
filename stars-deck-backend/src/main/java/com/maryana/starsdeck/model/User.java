package com.maryana.starsdeck.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String userName;
    private String bio;
    private String avatarUrl;
    private Integer points;
    private List<Event> events = new ArrayList<>();

    public User(String name, String userName, String bio, String avatarUrl, Integer points, List<Event> events) {
        this.name = name;
        this.userName = userName;
        this.bio = bio;
        this.avatarUrl = avatarUrl;
        this.points = points;
        this.events = events;
    }
}
