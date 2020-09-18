package com.github.mbritzke.repository;

import com.github.mbritzke.entity.KeyWordEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyWordRepository extends CrudRepository<KeyWordEntity, Integer> {

}
