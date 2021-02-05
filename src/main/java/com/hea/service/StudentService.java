package com.hea.service;

import java.util.List;

import com.hea.entity.Student;

public interface StudentService {

	public Student createStudent(Student student);

	public void deleteStudent(String id);

	public Student getStudentById(String id);

	public Student updateStudent(Student s, String id);

	public List<Student> getAllStudents();

	public List<Student> getAllStudentsByName(String name);

	public Student studentByNameAndEmail(String name, String email);

	public List<Student> studentByNameOrMail(String name, String email);

	/*
	 * public List<Student> byDepartmentName(String departmentName);
	 * 
	 * public List<Student> bySubjectName(String subjectName);
	 */

	public List<Student> findByEmailLike(String email);

	public List<Student> nameStartsWith(String name);

	// public List<Student> getAllWithPagination(int pageNo, int pageSize);

	public List<Student> allWithSorting();

	public List<Student> findStudentsByDepartmentId(String id);

}
