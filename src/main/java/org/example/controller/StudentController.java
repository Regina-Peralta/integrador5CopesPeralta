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


	@Operation(summary = "Devolver estudiantes",
			description = "Devuelve todos los estudiantes",
			tags = "estudiantes")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de estudiantes",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = List.class)) }),
			@ApiResponse(responseCode = "404", description = "Not found",
					content = @Content) })
	@GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }


	@Operation(summary = "Insertar un estudiante",
			description = "Inserta un estudiante que recibe por parametro",
			tags = "estudiantes")
	@ApiResponses(value = {
			@ApiResponse(description = "Success", responseCode = "200",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = Boolean.class))),
			@ApiResponse(responseCode = "400", description = "Bad request",
					content = @Content) })
	@PostMapping
    public boolean insertStudent(@RequestBody Student student) {
        return studentService.insertStudent(student);
    }
	

	@Operation(summary = "Devolver estudiantes ordenados alfabeticamente",
			description = "Devuelve todos los estudiantes ordenados alfabeticamente",
			tags = "estudiantes")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de estudiantes",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = List.class)) }),
			@ApiResponse(responseCode = "404", description = "Not found",
					content = @Content) })
	@GetMapping("/sortedByName")
	public List<Student> getStudentsWithOrderByName() {
		return studentService.getStudentsWithOrderByName();
	}
	

	@Operation(summary = "Devolver estudiantes filtrados por genero",
			description = "Devuelve todos los estudiantes filtrados por el genero que recibe por parametro",
			tags = "estudiantes")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de estudiantes de un genero particular",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = List.class)) }),
			@ApiResponse(responseCode = "404", description = "Not found",
					content = @Content) })
	@GetMapping("/gender/{gender}")
	public List<Student> getStudentsByGender(@PathVariable("gender") char gender) {
		return studentService.getStudentsByGender(gender);
	}


	@Operation(summary = "Devolver estudiante",
			description = "Devuelve un estudiante segun el numero de LU",
			tags = "estudiantes")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Estudiante",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = Student.class)) }),
			@ApiResponse(responseCode = "404", description = "Not found",
					content = @Content) })
	@GetMapping("/lu/{LU}")
	public Student getStudentByLU(@PathVariable("LU") Long LU) {
		return studentService.getStudentByLU(LU);
	}
}
