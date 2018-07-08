package com.example.SpringTutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SpringTutorial.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
