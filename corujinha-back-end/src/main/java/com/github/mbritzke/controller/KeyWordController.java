package com.github.mbritzke.controller;

import com.github.mbritzke.entity.KeyWordEntity;
import com.github.mbritzke.repository.KeyWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/keywords")
public class KeyWordController {

    @Autowired
    private KeyWordRepository keyWordRepository;

    @PostMapping(path = "/add")
    public ResponseEntity<KeyWordEntity> addNewWord(@RequestBody KeyWordEntity word) {
        KeyWordEntity keyWordEntity = new KeyWordEntity();
        keyWordEntity.setWord(word.getWord());
        return ResponseEntity.status(201).body(keyWordRepository.save(keyWordEntity));
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<KeyWordEntity> getAllWords() {
        return keyWordRepository.findAll();
    }
}
