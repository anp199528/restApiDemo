package com.example.restapidemo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudOperationRepository extends JpaRepository<CrudOperation, Integer> {
}
