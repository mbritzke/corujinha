package com.github.mbritzke.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mbritzke.dto.KeyWordDto;
import com.github.mbritzke.entity.KeyWordEntity;
import com.github.mbritzke.exception.EmptyKeyWordException;
import com.github.mbritzke.repository.KeyWordRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class KeyWordService {

    private final ObjectMapper objectMapper;
    private final KeyWordRepository keyWordRepository;

    public KeyWordService(ObjectMapper objectMapper, KeyWordRepository keyWordRepository) {
        this.objectMapper = objectMapper;
        this.keyWordRepository = keyWordRepository;
    }

    public KeyWordDto addNewKeyWord(KeyWordDto keyWordDto) {
        if (StringUtils.isEmpty(keyWordDto.getWord()))
            throw new EmptyKeyWordException();
        KeyWordEntity keyWordEntity = objectMapper.convertValue(keyWordDto, KeyWordEntity.class);
        return objectMapper.convertValue(keyWordRepository.save(keyWordEntity), KeyWordDto.class);
    }

    public List<KeyWordDto> getAllKeyWords() {
        Iterable<KeyWordEntity> keyWordEntities = keyWordRepository.findAll();
        List<KeyWordDto> keyWordDtoList = new ArrayList<>();
        for (KeyWordEntity keyWordEntity: keyWordEntities) {
            keyWordDtoList.add(objectMapper.convertValue(keyWordEntity, KeyWordDto.class));
        }
        return keyWordDtoList;
    }
}
