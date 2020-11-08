package com.github.mbritzke.repository;

import com.github.mbritzke.entity.KeyWordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyWordRepository extends JpaRepository<KeyWordEntity, Integer> {

}
