package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Section;
import com.bezkoder.springjwt.models.SectionSubjects;
import com.bezkoder.springjwt.payload.request.SectionRequest;
import com.bezkoder.springjwt.payload.response.MessageResponse;
import com.bezkoder.springjwt.repository.SectionRepository;
import com.bezkoder.springjwt.repository.SectionSubjectsRepository;
import com.bezkoder.springjwt.security.services.SectionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/section")
public class SectionController {

    @Autowired
    SectionService sectionService;


@PostMapping("/addSection")
    public ResponseEntity<?> addSection(@Valid @RequestBody SectionRequest sectionRequest){
    return sectionService.createSection(sectionRequest);

}


// Sections means ClassDetails


    @GetMapping("/sections")
//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Section> getSections() {
        return this.sectionService.getSections();
    }

//    @GetMapping("/{id}")
//    public Section getSectionById(@PathVariable int id) {
//        return sectionRepository.findById(id);
//    }

//    @GetMapping("/{name}")
//    public Section getSectionByName(@PathVariable String name) {
//        return sectionRepository.findByName(name);
//    }



//    @GetMapping("/sections/{id}" )
////    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//    public Section findById(@PathVariable("id") int id) {
//        return this.sectionRepository.findById(id);
////        return sectionSubjectsRepository.findBySectionId(id);
//    }



    @GetMapping("/getAll/{id}")
    public List<SectionSubjects> fetchAll(@PathVariable("id") Integer id){
        return this.sectionService.findBySectionId(id);
    }


}
