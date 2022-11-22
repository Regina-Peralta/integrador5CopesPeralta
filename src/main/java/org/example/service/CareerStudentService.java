package org.example.service;

import org.example.dto.CareerInscriptionsDTO;
import org.example.dto.CareerReportDTO;
import org.example.entity.CareerStudent;
import org.example.entity.Student;
import org.example.repository.CareerStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerStudentService {
	@Autowired
    private CareerStudentRepository careerStudentRepository;
	
	public List<Student> getStudentsByCareerFilterCity(Long idCarrera, String ciudad){
		return careerStudentRepository.getStudentsByCareerFilterCity(idCarrera, ciudad);
	}
	
	public List<CareerInscriptionsDTO> getInscriptionSortedByCareer(){
		return careerStudentRepository.getInscriptionSortedByCareer();
	}
	
	public List<CareerReportDTO> getReportCareer(){
		return careerStudentRepository.getReportCareer();
	}

	public CareerStudent enrollStudent(CareerStudent cs){
		return careerStudentRepository.save(cs);
	}

}
