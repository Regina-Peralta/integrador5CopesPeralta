package org.example.repository;

import org.example.entity.Career;
import org.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CareerRepository extends JpaRepository<Career,Long> {
    @Query("SELECT DISTINCT c FROM Career c JOIN c.students s WHERE size(s) > 0 ORDER BY size(s)")
    List<Career> getAllCareersByStudentsAmount();

    @Query("SELECT DISTINCT c FROM Career c")
    List<Career> getCareers();

}
