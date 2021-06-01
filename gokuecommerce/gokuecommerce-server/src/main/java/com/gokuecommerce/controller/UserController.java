package com.gokuecommerce.controller;

import static com.gokuecommerce.security.JWTUtil.validateUsername;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gokuecommerce.model.User;
import com.gokuecommerce.model.dto.UserDTO;
import com.gokuecommerce.service.UserService;

import io.swagger.annotations.Api;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/users")
@Api(tags = "Maintenance Users")
public class UserController {

    @Autowired
    private UserService service;

    @SneakyThrows
    @PostMapping
    public ResponseEntity<Void> addUser(@Valid @RequestBody User user) {
        service.saveUser(user);
        return ResponseEntity.created(URI.create("/login")).build();
    }

    @SneakyThrows
    @PutMapping
    public ResponseEntity<Void> editUser(@RequestHeader String authorization, @Valid @RequestBody UserDTO userDTO) {
        validateUsername(authorization, userDTO.getUsername());

        User user = User.builder()
                .name(userDTO.getName())
                .password(userDTO.getPassword())
                .build();

        service.updateUser(user);
        return ResponseEntity.accepted().build();
    }
}
