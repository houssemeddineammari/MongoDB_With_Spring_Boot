package com.hea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hea.entity.Student;
import com.hea.service.StudentService;

@RestController
@RequestMapping("/api/studentCrudApplication")
public class StudentRest {

	@Autowired
	private StudentService studentService;

	@PostMapping("/create")
	public Student createStudent(@RequestBody Student s) {
		return studentService.createStudent(s);
	}

	@DeleteMapping("/remove/{id}")
	public void deleteStudent(@PathVariable String id) {
		studentService.deleteStudent(id);
		System.out.println("Student deleted ...");
	}

	@GetMapping("/student/{id}")
	public Student findStudentById(@PathVariable String id) {
		return studentService.getStudentById(id);
	}

	@PutMapping("/student/{id}")
	public Student updateStudent(@RequestBody Student s, @PathVariable String id) {
		return studentService.updateStudent(s, id);
	}

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@GetMapping("/students/{name}")
	public List<Student> getAllStudentsByName(@PathVariable String name) {
		return studentService.getAllStudentsByName(name);
	}

	@GetMapping("/findStudentByNameAndEemail")
	public Student findStudentByNameAndEemail(@RequestParam String name, @RequestParam String email) {
		return studentService.studentByNameAndEmail(name, email);
	}

	@GetMapping("/findStudentByNameOrEmail")
	public List<Student> findStudentByNameOrEmail(@RequestParam String name, @RequestParam String email) {
		return studentService.studentByNameOrMail(name, email);
	}

	/*
	 * @GetMapping("/byDepartmentName") public List<Student>
	 * byDepartmentName(@RequestParam String departmentName) { return
	 * studentService.byDepartmentName(departmentName); }
	 * 
	 * @GetMapping("/bySubjectName") public List<Student>
	 * bySubjectName(@RequestParam String subjectName) { return
	 * studentService.bySubjectName(subjectName); }
	 */

	@GetMapping("/byEmailLike")
	public List<Student> byEmailLike(@RequestParam String email) {
		return studentService.findByEmailLike(email);
	}

	@GetMapping("/allWithSorting")
	public List<Student> getAllWithSorting() {
		return studentService.allWithSorting();
	}

	@GetMapping("/students/department/{id}")
	public List<Student> getAllByDepartmentId(@PathVariable String id) {
		return studentService.findStudentsByDepartmentId(id);
	}

	@GetMapping("/studentsByName")
	public List<Student> StudentsByName(@RequestParam String name) {
		return studentService.findStudentsByName(name);
	}

}
