package com.maryana.starsdeck.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GithubUserResponse {

    @JsonProperty("name")
    private String name;

    @JsonProperty("login")
    private String userName;

    @JsonProperty("bio")
    private String bio;

    @JsonProperty("avatar_url")
    private String avatarUrl;
}
