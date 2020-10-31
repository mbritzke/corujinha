package com.github.mbritzke.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mbritzke.dto.AddressDto;
import com.github.mbritzke.entity.AddressEntity;
import com.github.mbritzke.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private final ObjectMapper objectMapper;
    private final AddressRepository addressRepository;

    public AddressService(ObjectMapper objectMapper, AddressRepository addressRepository) {
        this.objectMapper = objectMapper;
        this.addressRepository = addressRepository;
    }

    public AddressDto addNewAddress(AddressDto addressDto) {
        AddressEntity addressEntity = objectMapper.convertValue(addressDto, AddressEntity.class);
        return objectMapper.convertValue(addressRepository.save(addressEntity), AddressDto.class);
    }

    public List<AddressDto> getAddressesForKeyWord(Integer keyWordId) {
        List<AddressEntity> addressEntities = addressRepository.findAllByKeyWordId(keyWordId);
        return addressEntities.stream().map(
                addressEntity -> objectMapper.convertValue(addressEntity, com.github.mbritzke.dto.AddressDto.class))
                .collect(Collectors.toList());
    }
}
