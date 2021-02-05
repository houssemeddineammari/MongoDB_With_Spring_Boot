package com.hea.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hea.entity.Department;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {

}
