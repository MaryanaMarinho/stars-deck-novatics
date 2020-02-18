package com.maryana.starsdeck.service;

import com.maryana.starsdeck.model.User;
import com.maryana.starsdeck.repository.UserRepository;
import com.maryana.starsdeck.service.exception.ObjectNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService service;

    @Mock
    private UserRepository repository;

    @Test
    public void mustFindAllUsers() {

        User user = new User();
        user.setId("123");

        List<User> list = new ArrayList<>();
        list.add(user);

        Mockito.when(repository.findAll()).thenReturn(list);

        List<User> response = service.findAll();

        Assert.assertNotNull(response);
        Assert.assertEquals("123",response.get(0).getId());
    }

    @Test
    public void mustFindUserById() {

        User user = new User();
        user.setId("123");

        Optional<User> optionalUser = Optional.of(user);

        Mockito.when(repository.findById("123")).thenReturn(optionalUser);

        User response = service.findById("123");

        Assert.assertNotNull(response);
    }

    @Test(expected = ObjectNotFoundException.class)
    public void mustFindUserByIdException() throws Exception {

        Assert.assertEquals("Object not found", service.findById("321"));

    }
}
