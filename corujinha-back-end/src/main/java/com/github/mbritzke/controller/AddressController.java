package com.github.mbritzke.controller;

import com.github.mbritzke.dto.AddressDto;
import com.github.mbritzke.exception.EmptyAddressException;
import com.github.mbritzke.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<AddressDto> addNewAddress(@RequestBody AddressDto addressDto) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(addressService.addNewAddress(addressDto));
        } catch (EmptyAddressException emptyAddressException) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @GetMapping("/{keyWordId}")
    public ResponseEntity<List<AddressDto>> getAddressesByKeyWordId(@PathVariable("keyWordId") Integer keyWordId) {
        return ResponseEntity.ok(addressService.getAddressesByKeyWordId(keyWordId));
    }
}
