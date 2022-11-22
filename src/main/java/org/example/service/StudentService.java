package org.example.service;

import org.example.entity.Student;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public boolean insertStudent(Student student) {
        try {
			studentRepository.save(student);
			return true;
		}catch (Exception e){
			return false;
		}
	}

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

	public List<Student> getStudentsWithOrderByName() {
		return studentRepository.findStudentsOrderByLastName();
	}

	public List<Student> getStudentsByGender(char gender) {
		return studentRepository.findAllByGender(gender);
	}
	
	public Student getStudentByLU(Long LU) {
		return studentRepository.findByLU(LU);
	}


    
    
}
