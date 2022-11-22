package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.dto.CareerInscriptionsDTO;
import org.example.dto.CareerReportDTO;
import org.example.entity.Student;
import org.example.service.CareerStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/careerStudent")
public class CareerStudentController {
	
	@Autowired
	private CareerStudentService careerStudentService ;
	

	@Operation(summary = "Inscriptos por carrera",
			description = "Devuelve todos los inscriptos ordenados por carrera",
			tags = "inscriptos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de inscriptos por carreras",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = List.class)) }),
			@ApiResponse(responseCode = "404", description = "Not found",
					content = @Content) })
	@GetMapping("/sortedByInscriptions")
	public List<CareerInscriptionsDTO>getInscriptionSortedByCareer(){
		return careerStudentService.getInscriptionSortedByCareer();
	}
	

	@Operation(summary = "Devolver inscriptos segun ciudad",
			description = "Devuelve todos inscriptos en una ciudad determinada",
			tags = "inscriptos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de inscriptos en una ciudad determinada",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = List.class)) }),
			@ApiResponse(responseCode = "404", description = "Not found",
					content = @Content) })
	@GetMapping
	public List<Student> getStudentsByCareerFilterCity(@RequestParam("careerId") Long id, @RequestParam("city") String city){
		return careerStudentService.getStudentsByCareerFilterCity(id, city);
	}
	

	@Operation(summary = "Devolver reporte",
			description = "Devuelve el reporte de las carreras con sus inscriptos",
			tags = "reporte")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Reporte",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = List.class)) }),
			@ApiResponse(responseCode = "404", description = "Not found",
					content = @Content) })
	@GetMapping("/report")
	public List<CareerReportDTO> getReportCareer() {
		return careerStudentService.getReportCareer();
	}
}