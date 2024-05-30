package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.models.Subject;
import com.bezkoder.springjwt.payload.request.SubjectRequest;
import com.bezkoder.springjwt.payload.response.MessageResponse;
import com.bezkoder.springjwt.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    public ResponseEntity<?> addSubject(SubjectRequest subjectRequest) {
        Subject sub = new Subject(subjectRequest.getSubjectName(), subjectRequest.getMedium(), subjectRequest.getTeacherName());
        subjectRepository.save(sub);
        return ResponseEntity.ok(new MessageResponse("Subject Added successfully!"));
    }

    public List<Subject> getsubjects() {
        return this.subjectRepository.findAll();
    }


}
