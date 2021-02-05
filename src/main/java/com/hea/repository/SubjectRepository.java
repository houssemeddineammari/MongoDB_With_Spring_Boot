package com.hea.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hea.entity.Subject;

@Repository
public interface SubjectRepository extends MongoRepository<Subject, String> {

}
