package com.hea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hea.entity.Student;
import com.hea.repository.DepartmentRepository;
import com.hea.repository.StudentRepository;
import com.hea.repository.SubjectRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private DepartmentRepository departmentRepo;

	@Autowired
	private SubjectRepository subjectRepo;

	public Student createStudent(Student student) {
		if (student.getDepartment() != null) {
			departmentRepo.save(student.getDepartment());
		}
		if (student.getSubjects() != null && student.getSubjects().size() > 0) {
			subjectRepo.saveAll(student.getSubjects());
		}
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
		tobeUpdated.setDepartment(s.getDepartment());
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

//	@Override
//	public List<Student> getAllWithPagination(int pageNo, int pageSize) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<Student> allWithSorting() {
		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		return studentRepo.findAll(sort);
	}

	/*
	 * public List<Student> byDepartmentName(String departmentName) { return
	 * studentRepo.findByDepartmentDepartmentName(departmentName); }
	 * 
	 * @Override public List<Student> bySubjectName(String subjectName) { return
	 * studentRepo.findBySubjectsSubjectName(subjectName); }
	 */

	@Override
	public List<Student> findByEmailLike(String email) {
		return studentRepo.findByEmailLike(email);
	}

	@Override
	public List<Student> nameStartsWith(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudentsByDepartmentId(String id) {

		return studentRepo.findByDepartmentIdDept(id);
	}

}
