package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.models.Subject;
import com.bezkoder.springjwt.payload.request.SubjectRequest;
import com.bezkoder.springjwt.payload.response.MessageResponse;
import com.bezkoder.springjwt.repository.SubjectRepository;
import com.bezkoder.springjwt.security.services.SubjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @PostMapping("/addsubject")
    public ResponseEntity<?> addSubject(@Valid @RequestBody SubjectRequest subjectRequest) {
        return subjectService.addSubject(subjectRequest);
    }

    @GetMapping("/subjects")
//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Subject> getSubjects() {
        return subjectService.getsubjects();
    }


}
