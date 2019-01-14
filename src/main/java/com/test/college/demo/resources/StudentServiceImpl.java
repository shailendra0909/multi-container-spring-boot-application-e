package com.test.college.demo.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentIService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		List<Student> studentList = new ArrayList<>();
		studentRepository.findAll().forEach(student -> {
			studentList.add(student);
		});
		return studentList;
	}

	@Override
	public Student getStudent(String id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student createStudent(Student student) {
		String id = UUID.randomUUID().toString();
		student.setId(id);
		studentRepository.save(student);
		return this.getStudent(id);
	}

	@Override
	public Student updateStudent(Student student) {
		studentRepository.save(student);
		return this.getStudent(student.getId());
	}

	@Override
	public void deleteStudent(String id) {
		studentRepository.deleteById(id);
	}

}
