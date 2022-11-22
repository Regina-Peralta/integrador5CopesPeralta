package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.entity.Career;
import org.example.service.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/career")
public class CareerController {

	@Autowired
    private CareerService careerService;


    @GetMapping("/sortedByStudent")
    public List<Career> getCareersOrderByStudents() {
        return careerService.getCareersOrderByStudents();
    }


    @GetMapping("/")
    public List<Career> getCareers() {
        return careerService.getCareers();
    }
}