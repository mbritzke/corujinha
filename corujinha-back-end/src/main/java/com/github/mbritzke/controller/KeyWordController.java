package com.github.mbritzke.controller;

import com.github.mbritzke.dto.KeyWordDto;
import com.github.mbritzke.exception.EmptyKeyWordException;
import com.github.mbritzke.service.KeyWordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/keywords")
public class KeyWordController {

    private final KeyWordService keyWordService;

    public KeyWordController(KeyWordService keyWordService) {
        this.keyWordService = keyWordService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<KeyWordDto> addNewWord(@RequestBody KeyWordDto keyWordDto) throws EmptyKeyWordException {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(keyWordService.addNewKeyWord(keyWordDto));
        } catch (EmptyKeyWordException emptyKeyWordException) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<KeyWordDto>> getAllWords() {
        return ResponseEntity.ok(keyWordService.getAllKeyWords());
    }
}
