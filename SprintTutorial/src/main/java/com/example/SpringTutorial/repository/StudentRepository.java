package com.example.SpringTutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SpringTutorial.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
