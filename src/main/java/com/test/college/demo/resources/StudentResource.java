package com.test.college.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentResource {

	@Autowired
	private StudentIService studentService;

	@RequestMapping(method = RequestMethod.GET, value = "/students")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/students/{id}")
	public Student getStudent(@PathVariable String id) {
		return studentService.getStudent(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/students")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/students/{id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable String id) {
		return studentService.updateStudent(student);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/students/{id}")
	public void deleteStudent(@PathVariable String id) {
		studentService.deleteStudent(id);
	}

}
