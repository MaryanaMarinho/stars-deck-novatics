package com.maryana.starsdeck.repository;

import com.maryana.starsdeck.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUserName(String userName);

    List<User> findAllByOrderByPointsDesc();
}
