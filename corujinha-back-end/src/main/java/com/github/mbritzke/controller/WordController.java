package com.github.mbritzke.controller;

import com.github.mbritzke.entity.WordEntity;
import com.github.mbritzke.repository.WordRepository;
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
public class WordController {

    @Autowired
    private WordRepository wordRepository;

    @PostMapping(path = "/add")
    public ResponseEntity<WordEntity> addNewWord(@RequestBody WordEntity word) {
        WordEntity wordEntity = new WordEntity();
        wordEntity.setWord(word.getWord());
        return ResponseEntity.status(201).body(wordRepository.save(wordEntity));
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<WordEntity> getAllWords() {
        return wordRepository.findAll();
    }
}
