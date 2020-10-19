package com.github.mbritzke.repository;

import com.github.mbritzke.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, Integer> {

    List<AddressEntity> findAllByKeyWordId(Integer keyWordId);
}
