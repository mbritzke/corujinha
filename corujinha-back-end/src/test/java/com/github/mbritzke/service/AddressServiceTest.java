package com.github.mbritzke.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mbritzke.dto.AddressDto;
import com.github.mbritzke.entity.AddressEntity;
import com.github.mbritzke.entity.KeyWordEntity;
import com.github.mbritzke.exception.EmptyAddressException;
import com.github.mbritzke.repository.AddressRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static stub.AddressDtoStub.createAddressDto;
import static stub.AddressDtoStub.createListOfAddresDto;
import static stub.AddressEntityStub.createAddressEntity;
import static stub.AddressEntityStub.createListOfAddressEntity;
import static stub.KeyWordEntityStub.createKeyWordEntity;

@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest {

    @Spy
    private ObjectMapper objectMapper;

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressService addressService;

    @Test
    public void shouldAddAddress() {
        AddressEntity addressEntity = createAddressEntity();
        Mockito.when(addressRepository.save(eq(addressEntity))).thenReturn(addressEntity);

        AddressDto expected = createAddressDto();
        AddressDto actual = addressService.addNewAddress(expected);
        Assertions.assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void shouldNotAddKeyWordWhenObjectIsEmpty() {
        Exception exception = assertThrows(EmptyAddressException.class, () -> {
            AddressDto addressDto = new AddressDto();
            addressService.addNewAddress(addressDto);
        });

        String expectedMessage = "Address not found";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void shouldGetAddressesForKeyWord() {
        KeyWordEntity keyWordEntity = createKeyWordEntity();
        Mockito.when(addressRepository.findAllByKeyWordId(eq(keyWordEntity.getId()))).thenReturn(createListOfAddressEntity());

        List<AddressDto> expected = createListOfAddresDto();
        List<AddressDto> actual = addressService.getAddressesByKeyWordId(keyWordEntity.getId());
        Assertions.assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }

    @Test
    public void shouldReturnEmptyValues() {
        KeyWordEntity keyWordEntity = createKeyWordEntity();
        Mockito.when(addressRepository.findAllByKeyWordId(eq(keyWordEntity.getId()))).thenReturn(new ArrayList<>());

        List<AddressDto> actual = addressService.getAddressesByKeyWordId(keyWordEntity.getId());
        assertTrue(actual.isEmpty());
    }
}