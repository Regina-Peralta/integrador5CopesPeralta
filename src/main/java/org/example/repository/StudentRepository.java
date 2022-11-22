package org.example.repository;

import org.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query("SELECT s FROM Student s ORDER BY s.lastname")
    List<Student>  findStudentsOrderByLastName();
    List<Student>  findAllByGender(char gender);
    Student findByLU(Long lu);

}
