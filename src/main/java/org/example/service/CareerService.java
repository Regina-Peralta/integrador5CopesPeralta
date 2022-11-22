package org.example.service;

import org.example.entity.Career;
import org.example.repository.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerService {
    @Autowired
    private CareerRepository careerRepository;

    public List<Career> getCareersOrderByStudents() {
        return careerRepository.getAllCareersByStudentsAmount();
    }

    public List<Career> getCareers() {
        return careerRepository.getCareers();
    }
}
