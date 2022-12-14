package com.project.retobackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.retobackend.model.Tests;

@Repository
public interface TestRepository extends CrudRepository <Tests, Long> {

}
