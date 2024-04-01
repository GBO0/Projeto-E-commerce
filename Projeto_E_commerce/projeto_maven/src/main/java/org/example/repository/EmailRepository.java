package org.example.repository;

import org.example.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<BaseModel, Integer> {
}
