package com.example.SpringTutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringTutorial.exception.EntityNotFoundException;
import com.example.SpringTutorial.model.Student;
import com.example.SpringTutorial.repository.StudentRepository;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	public Student getStudentById(Long id) {
		Optional<Student> checkExistantStudent = studentRepository.findById(id);
		if (checkExistantStudent.isPresent()) {
			return checkExistantStudent.get();	
		} else {
			throw new EntityNotFoundException(Student.class.getName(), id);
		}	
	}
	
	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	public void updateStudent(Long id, Student student) {
		Optional<Student> checkExistantStudent = studentRepository.findById(id);
		if (checkExistantStudent.isPresent()) {
			studentRepository.save(student);	
		} else {
			throw new EntityNotFoundException(Student.class.getName(), id);
		}
	}

	public void deleteStudent(Long id) {
		Optional<Student> checkExistantStudent = studentRepository.findById(id);
		if (checkExistantStudent.isPresent()) {
			studentRepository.deleteById(id);
		} else {
			throw new EntityNotFoundException(Student.class.getName(), id);
		}
	}
}
