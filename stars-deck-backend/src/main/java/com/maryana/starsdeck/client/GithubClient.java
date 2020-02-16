package com.maryana.starsdeck.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "githubService", url = "https://api.github.com/users")
public interface GithubClient {

    @GetMapping("/{login}")
    GithubUserResponse getUser(@PathVariable("login") String login);

}
