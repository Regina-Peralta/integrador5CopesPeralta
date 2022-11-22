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

	@GetMapping("/sortedByInscriptions")
	public List<CareerInscriptionsDTO>getInscriptionSortedByCareer(){
		return careerStudentService.getInscriptionSortedByCareer();
	}
	

	@GetMapping
	public List<Student> getStudentsByCareerFilterCity(@RequestParam("careerId") Long id, @RequestParam("city") String city){
		return careerStudentService.getStudentsByCareerFilterCity(id, city);
	}
	

	@GetMapping("/report")
	public List<CareerReportDTO> getReportCareer() {
		return careerStudentService.getReportCareer();
	}
}
