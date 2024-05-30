package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Student;
import com.bezkoder.springjwt.payload.request.StudentRequest;
import com.bezkoder.springjwt.payload.response.MessageResponse;
import com.bezkoder.springjwt.repository.StudentRepository;
import com.bezkoder.springjwt.security.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<?> addStudent(@Valid @RequestBody StudentRequest studentRequest) {
        return studentService.createStudent(studentRequest);
    }


    @GetMapping("/getStudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }


    @GetMapping("/getStudent/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Integer id) {
        return studentService.getStudent(id);
    }


    @PutMapping("/updateStudent/{id}")
    public Student updateStudent(@PathVariable Integer id,@RequestBody StudentRequest studentRequest){
        return  studentService.updateStudent(id,studentRequest);
    }


    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Integer id){
        return  studentService.deleteStudent(id);

    }


}
