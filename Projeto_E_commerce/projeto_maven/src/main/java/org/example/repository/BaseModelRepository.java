package org.example.repository;

import org.example.model.BaseModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BaseModelRepository {
    List<BaseModel> findAll();

    BaseModel save(BaseModel entity);

    Optional<BaseModel> findById(Integer id);
}
