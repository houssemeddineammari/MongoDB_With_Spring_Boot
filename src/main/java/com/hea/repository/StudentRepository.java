package com.hea.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.hea.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

	List<Student> getStudentsByName(String name);

	Student findByNameAndEmail(String name, String email);

	List<Student> findByNameOrEmail(String name, String email);

	/*
	 * Start code:
	 * 
	 * Those 2 queries are not going to work with DbRref department and DbRref
	 * subjects. Those are proxy methods, will work just with embedded sub documents
	 * but not with separate collection.
	 */
	// List<Student> findByDepartmentDepartmentName(String departmentName);

	// List<Student> findBySubjectsSubjectName(String subjectName);
	/*
	 * End code
	 * 
	 */

	List<Student> findByEmailLike(String email);

	/*
	 * 
	 * This is the new proxy method format when using separate collections
	 */
	List<Student> findByDepartmentIdDept(String id);

	@Query("{ \"name\" : \"?0\" }")
	List<Student> fetchStudentsByName(String name);

}
