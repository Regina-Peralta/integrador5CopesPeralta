package org.example.repository;


import org.example.dto.CareerInscriptionsDTO;
import org.example.dto.CareerReportDTO;
import org.example.entity.CareerStudent;
import org.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CareerStudentRepository  extends JpaRepository<CareerStudent,Long>{

    @Query("SELECT DISTINCT(s) FROM Student s, CareerStudent cs WHERE cs.career.id = :idCarrera AND s.city = :ciudad")
    List<Student> getStudentsByCareerFilterCity(@Param("idCarrera") Long idCarrera, @Param("ciudad") String ciudad);
    @Query("SELECT new org.example.dto.CareerInscriptionsDTO(ce.career.careerName, ce.career.id, COUNT(ce)) FROM CareerStudent ce JOIN Career c ON ce.career.id = c.id GROUP BY ce.id ORDER BY COUNT(ce.career.id)")
    List<CareerInscriptionsDTO> getInscriptionSortedByCareer();
    @Query("SELECT new org.example.dto.CareerReportDTO(c.careerName,ce.antiquity,ce.graduated,e.dni,e.LU,e.lastname,e.names) FROM Career c JOIN CareerStudent ce ON c.id = ce.career.id JOIN Student e ON ce.student.id=e.id ORDER BY c.careerName, ce.antiquity")
    List<CareerReportDTO> getReportCareer();

}
