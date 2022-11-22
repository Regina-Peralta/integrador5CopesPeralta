package org.example.repository;

import org.example.entity.Career;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CareerRepository {
    @Query("SELECT DISTINCT c,s.size FROM Career c JOIN c.students s WHERE s.size > 0 ORDER BY s.size DESC")
    List<Career> getAllCareersByStudentsAmount();
    @Query("SELECT DISTINCT c FROM Career c")
    List<Career> getCareers();

}
