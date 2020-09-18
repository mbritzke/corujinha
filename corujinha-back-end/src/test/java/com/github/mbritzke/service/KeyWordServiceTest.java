package com.github.mbritzke.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mbritzke.dto.KeyWordDto;
import com.github.mbritzke.entity.KeyWordEntity;
import com.github.mbritzke.exception.EmptyKeyWordException;
import com.github.mbritzke.repository.KeyWordRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static stub.KeyWordDtoStub.createKeyWordDto;
import static stub.KeyWordEntityStub.creatKeyWordEntity;

@RunWith(MockitoJUnitRunner.class)
public class KeyWordServiceTest {

    @Spy
    private ObjectMapper objectMapper;

    @Mock
    private KeyWordRepository keyWordRepository;

    @InjectMocks
    private KeyWordService keyWordService;

    @Test
    public void shouldAddKeyWord() {
        KeyWordEntity keyWordEntity = creatKeyWordEntity();
        Mockito.when(keyWordRepository.save(eq(keyWordEntity))).thenReturn(keyWordEntity);

        KeyWordDto expected = createKeyWordDto();
        KeyWordDto actual = keyWordService.addNewKeyWord(expected);
        Assertions.assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void shouldNotAddKeyWordWhenObjectIsEmpty() {
        Exception exception = assertThrows(EmptyKeyWordException.class, () -> {
            KeyWordDto keyWordDto = new KeyWordDto();
            keyWordService.addNewKeyWord(keyWordDto);
        });

        String expectedMessage = "keyword not found";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}