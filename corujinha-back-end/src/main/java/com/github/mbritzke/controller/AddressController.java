package com.github.mbritzke.controller;

import com.github.mbritzke.dto.AddressDto;
import com.github.mbritzke.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{keyWordId}")
    public ResponseEntity<List<AddressDto>> getAllWords(@PathVariable("keyWordId") Integer keyWordId) {
        return ResponseEntity.ok(addressService.getAddressesForKeyWord(keyWordId));
    }
}
