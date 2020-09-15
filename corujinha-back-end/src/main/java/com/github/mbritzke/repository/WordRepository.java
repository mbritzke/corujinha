package com.github.mbritzke.repository;

import com.github.mbritzke.entity.WordEntity;
import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends CrudRepository<WordEntity, Integer> {

}
