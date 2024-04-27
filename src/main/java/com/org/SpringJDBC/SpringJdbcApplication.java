package com.org.SpringJDBC;

import com.org.SpringJDBC.model.Student;
import com.org.SpringJDBC.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringJdbcApplication.class, args);

		Student student1 = context.getBean(Student.class);
		student1.setRollNo(1);
		student1.setName("Pavan");
		student1.setMarks(100);

		StudentService service = context.getBean(StudentService.class);
		service.addStudent(student1);

		List<Student> students = service.getStudents();

		System.out.println("List of Students : " + students.toString());
	}

}
