package com.bezkoder.springjwt.security.services;


import com.bezkoder.springjwt.models.Student;
import com.bezkoder.springjwt.payload.request.StudentRequest;
import com.bezkoder.springjwt.payload.response.MessageResponse;
import com.bezkoder.springjwt.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
   private StudentRepository studentRepository;

 // All CRUD Operations
    public List<Student> getAllStudents(){
        return  studentRepository.findAll();
    }


    public ResponseEntity<?> getStudent(Integer id){
        Student student = studentRepository.findById(id).orElse(null);
        if(student != null){
            return ResponseEntity.ok(student);
        }
        return  ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new MessageResponse("Student with id "+id+" is Not Exist"));
//                .badRequest()
//                .body(new MessageResponse("Student with id "+id+" is Not Exist"));
    }

    public ResponseEntity<?> createStudent(StudentRequest studentRequest){

        if (studentRepository.existsByFirstname(studentRequest.getFirstname()) && studentRepository.existsByLastname(studentRequest.getLastname()) && studentRepository.existsByMothername(studentRequest.getMothername()) && studentRepository.existsByDob(studentRequest.getDob())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Student already Registered"));
        }
        Student std = new Student(studentRequest.getFirstname(), studentRequest.getLastname(), studentRequest.getFathername(), studentRequest.getMothername(), studentRequest.getEmail(), studentRequest.getDob(), studentRequest.getContact(), studentRequest.getGender(), studentRequest.getReligion(), studentRequest.getCaste(), studentRequest.getAdhaarNo(), studentRequest.getAddress(), studentRequest.getSatsid(), studentRequest.getSchool(), studentRequest.getSection());
        studentRepository.save(std);
        return ResponseEntity.ok(new MessageResponse("Student Registered Successfully"));
    }


    public Student updateStudent(Integer id, StudentRequest studentRequest){
        Student student = studentRepository.findById(id).orElse(null);
        if(student != null ){
            student.setFirstname(studentRequest.getFirstname());
            student.setLastname(studentRequest.getLastname());
            student.setFathername(studentRequest.getFathername());
            student.setMothername(studentRequest.getMothername());
            student.setDob(studentRequest.getDob());
            student.setContact(studentRequest.getContact());
            student.setEmail(studentRequest.getEmail());
            student.setCaste(studentRequest.getCaste());
            student.setReligion(studentRequest.getReligion());
            student.setGender(studentRequest.getGender());
            student.setAddress(studentRequest.getAddress());
            student.setAdhaarNo(studentRequest.getAdhaarNo());
            student.setSection(studentRequest.getSection()) ;
            student.setSatsid(studentRequest.getSatsid());
            student.setSchool(studentRequest.getSchool());
            return studentRepository.save(student);
        }
        return null;
    }


    public String deleteStudent(Integer id){
        studentRepository.deleteById(id);
        return "id "+id+" Deleted Successfully";
    }



}
