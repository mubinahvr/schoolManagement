package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.SectionSubjects;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SectionSubjectsRepository extends JpaRepository<SectionSubjects, Integer> {
   List<SectionSubjects>  findBySectionId(Integer sectionId);

//    @Transactional
//    void deleteBySectionId(int sectionId);


//    SectionSubjects findById(Integer id);


//    @Query("SELECT s FROM SectionSubjects s")
//    List<SectionSubjects> getClassDetailsWithSubjectId();


    List<SectionSubjects> findBySectionName(String sectionName);


}
