package com.hea;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hea.app.SpringMongoBegginerApplication;
import com.hea.entity.Student;
import com.hea.repository.StudentRepository;

@SpringBootTest(classes={SpringMongoBegginerApplication.class})
class SpringMongoBegginerApplicationTests {

	@Autowired
	private StudentRepository studentRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void addStudent() {
		Student s = new Student();
		s.setName("Houssem Eddine");
		s.setEmail("houssem@gmail.com");
		studentRepo.save(s);
		
	}

}
