package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.entity.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

	@GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }


	@PostMapping
    public boolean insertStudent(@RequestBody Student student) {
        return studentService.insertStudent(student);
    }


	@GetMapping("/sortedByName")
	public List<Student> getStudentsWithOrderByName() {
		return studentService.getStudentsWithOrderByName();
	}

	@GetMapping("/gender/{gender}")
	public List<Student> getStudentsByGender(@PathVariable("gender") char gender) {
		return studentService.getStudentsByGender(gender);
	}

	@GetMapping("/lu/{LU}")
	public Student getStudentByLU(@PathVariable("LU") Long LU) {
		return studentService.getStudentByLU(LU);
	}
}
