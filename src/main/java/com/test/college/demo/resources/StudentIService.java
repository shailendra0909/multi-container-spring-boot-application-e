package com.test.college.demo.resources;

import java.util.List;

public interface StudentIService {
	public List<Student> getAllStudents();

	public Student getStudent(String id);

	public Student createStudent(Student student);

	public Student updateStudent(Student student);

	public void deleteStudent(String id);
}
