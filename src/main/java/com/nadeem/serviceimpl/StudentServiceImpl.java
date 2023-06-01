package com.nadeem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nadeem.model.Student;
import com.nadeem.repository.StudentRepository;
import com.nadeem.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void saveStudent(Student student) {
	   studentRepository.save(student);
	}

	@Override
	public List<Student> finAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(long id) {
	Student student =	studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Student ID" +id));
	studentRepository.delete(student);
	return student;
	}
	
}
