package com.gokuecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gokuecommerce.model.Address;
import com.gokuecommerce.service.PostalCodeService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping
@Api(tags = "Find Postal Code")
public class PostalCodeController {

    @Autowired
    private PostalCodeService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/addresses/{postalCode}")
    public ResponseEntity<Address> findPostalCode(@PathVariable String postalCode) {
        return new ResponseEntity<Address>(service.getAddressFindPostalCode(postalCode), HttpStatus.OK);
    }
}
