package com.gokuecommerce.controller;

import javax.validation.Valid;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gokuecommerce.model.Address;
import com.gokuecommerce.model.User;
import com.gokuecommerce.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/users/{username}/address")
@Api(tags = "Maintenance Address")
public class AddressController {

    private UserService service;

    @GetMapping
    public ResponseEntity<Address> findAddress(@RequestParam String username) throws NotFoundException {
        User user = service.findUserByUsername(username);
        return new ResponseEntity<Address>(user.getAddress(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Address> updateAddress(@RequestParam String username, @Valid @RequestBody Address address) throws NotFoundException {
        User user = service.updateUser(User.builder().username(username).address(address).build());
        return new ResponseEntity<Address>(user.getAddress(), HttpStatus.OK);
    }
}
