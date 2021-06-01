package com.gokuecommerce.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.gokuecommerce.model.dto.LoginDTO;
import com.gokuecommerce.service.LoginSessionService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Api(tags = "Login Session User")
public class LoginSessionController {

    @Autowired
    private LoginSessionService service;

    @PostMapping(path = "/login")
    public ResponseEntity<Void> login(@Valid @RequestBody LoginDTO login) throws Exception {
        String token = service.loginUser(login.getUsername(), login.getPassword());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Authorization", "Bearer " + token);
        return ResponseEntity.ok().headers(responseHeaders).build();
    }

}
