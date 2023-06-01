package com.nadeem.service;

import java.util.List;

import com.nadeem.model.Student;

public interface StudentService {

	void saveStudent(Student student);

	List<Student> finAll();

	Student findById(long id);
		
	

}
