package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.SectionSubjects;
import com.bezkoder.springjwt.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Boolean existsByFirstname(String firstname);

    Boolean existsByLastname(String lastname);

    Boolean existsByMothername(String mothername);

    Boolean existsByDob (LocalDate dob);

    @Query("SELECT s FROM Student s")
    List<Student> getStudentsByQuery();

}
