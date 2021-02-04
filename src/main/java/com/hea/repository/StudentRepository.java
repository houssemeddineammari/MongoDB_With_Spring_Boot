package com.hea.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hea.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

	List<Student> getStudentsByName(String name);

	Student findByNameAndEmail(String name, String email);
	
	List<Student> findByNameOrEmail(String name, String email);

}
