package com.hea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hea.entity.Student;
import com.hea.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	public Student createStudent(Student student) {
		return studentRepo.save(student);
	}

	public void deleteStudent(String id) {
		Student student = studentRepo.findById(id).get();
		studentRepo.delete(student);
	}

	@Override
	public Student getStudentById(String id) {
		Student student = studentRepo.findById(id).get();
		return student;
	}

	@Override
	public Student updateStudent(Student s, String id) {
		Student tobeUpdated = studentRepo.findById(id).get();
		tobeUpdated.setName(s.getName());
		tobeUpdated.setEmail(s.getEmail());
		tobeUpdated.setDepartement(s.getDepartement());
		tobeUpdated.setSubjects(s.getSubjects());
		studentRepo.save(tobeUpdated);
		return tobeUpdated;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public List<Student> getAllStudentsByName(String name) {
		return studentRepo.getStudentsByName(name);
	}

	@Override
	public Student studentByNameAndEmail(String name, String email) {
		return studentRepo.findByNameAndEmail(name, email);
	}

	@Override
	public List<Student> studentByNameOrMail(String name, String email) {
		return studentRepo.findByNameOrEmail(name, email);
	}

	@Override
	public List<Student> getAllWithPagination(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> allWithSorting() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> byDepartmentName(String deptName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> bySubjectName(String subName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> emailLike(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> nameStartsWith(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
