package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.models.Section;
import com.bezkoder.springjwt.models.SectionSubjects;
import com.bezkoder.springjwt.payload.request.SectionRequest;
import com.bezkoder.springjwt.payload.response.MessageResponse;
import com.bezkoder.springjwt.repository.SectionRepository;
import com.bezkoder.springjwt.repository.SectionSubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SectionService {

    @Autowired
    SectionSubjectsRepository sectionSubjectsRepository;

    @Autowired
    SectionRepository sectionRepository;



    public ResponseEntity<?> createSection(SectionRequest sectionRequest){
        Section cls = new Section(sectionRequest.getName(),sectionRequest.getAcademicYear(),sectionRequest.getTeacherName());
        sectionRepository.save(cls);
        return  ResponseEntity.ok(new MessageResponse("Class Added successfully!"));
    }


    public List<SectionSubjects> findBySectionId(Integer id){
        return this.sectionSubjectsRepository.findBySectionId(id);
    }


    public List<Section> getSections(){
        return this.sectionRepository.findAll();
    }



}
