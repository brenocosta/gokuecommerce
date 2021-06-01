package com.gokuecommerce.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gokuecommerce.model.Address;

@FeignClient(name = "postalCodeService", url = "https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente")
public interface PostalCodeService {

    @RequestMapping("/{postalCode}/json")
    Address getAddressFindPostalCode(@PathVariable("postalCode") String postalCode);
}
