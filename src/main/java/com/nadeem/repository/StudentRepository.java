package com.nadeem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nadeem.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
