package com.gokuecommerce.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.gokuecommerce.exception.BadRequestException;
import com.gokuecommerce.exception.UserAlreadyExistsException;
import com.gokuecommerce.exception.UserNotFoundException;
import com.gokuecommerce.model.User;
import com.gokuecommerce.repository.UserRepository;
import com.gokuecommerce.security.HashUtil;

import lombok.SneakyThrows;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    @SneakyThrows
    @Cacheable(value = "user", key = "#username")
    public User findUserByUsername(String username) {
        return repository.findByUsername(username).orElseThrow(UserNotFoundException::new);
    }

    @Cacheable(value = "user", key = "#username")
    public User checkUserLogin(String username, String password) {
        return repository.findByUsernameAndPassword(username, password).orElseThrow(UserNotFoundException::new);
    }

    public User saveUser(User user) throws Exception {
        if (repository.findByUsername(user.getUsername()).isPresent())
            throw new UserAlreadyExistsException();

        user.setPassword(HashUtil.encryptPassword(user.getPassword()));
        return repository.save(user);
    }

    @SneakyThrows
    public User updateUser(User user) throws NotFoundException {
        if (Objects.isNull(user.getPassword()) && Objects.isNull(user.getPassword())
                && Objects.isNull(user.getAddress()))
            throw new BadRequestException("Fill some fields");

        User oldUser = findUserByUsername(user.getUsername());

        if (Objects.nonNull(user.getAddress()))
            oldUser.setAddress(user.getAddress());

        if (Objects.nonNull(user.getPassword())) {
            oldUser.setPassword(HashUtil.encryptPassword(user.getPassword()));
        }

        if (Objects.nonNull(user.getName()))
            oldUser.setName(user.getName());

        return repository.save(oldUser);
    }
}
