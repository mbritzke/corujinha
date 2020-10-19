package com.github.mbritzke.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mbritzke.dto.AddressDto;
import com.github.mbritzke.entity.KeyWordEntity;
import com.github.mbritzke.repository.AddressRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static stub.AddressDtoStub.createListOfAddresDto;
import static stub.AddressEntityStub.createListOfAddressEntity;
import static stub.KeyWordEntityStub.creatKeyWordEntity;

@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest {

    @Spy
    private ObjectMapper objectMapper;

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressService addressService;

    @Test
    public void shouldGetAddressesForKeyWord() {
        KeyWordEntity keyWordEntity = creatKeyWordEntity();
        Mockito.when(addressRepository.findAllByKeyWordId(eq(keyWordEntity.getId()))).thenReturn(createListOfAddressEntity());

        List<AddressDto> expected = createListOfAddresDto();
        List<AddressDto> actual = addressService.getAddressesForKeyWord(keyWordEntity.getId());
        Assertions.assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }

    @Test
    public void shouldReturnEmptyValues() {
        KeyWordEntity keyWordEntity = creatKeyWordEntity();
        Mockito.when(addressRepository.findAllByKeyWordId(eq(keyWordEntity.getId()))).thenReturn(new ArrayList<>());

        List<AddressDto> actual = addressService.getAddressesForKeyWord(keyWordEntity.getId());
        Assert.assertTrue(actual.isEmpty());
    }
}