package com.aniruddha.studentmangmentportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add-student")
    public ResponseEntity addStudent(@RequestBody Student student) {
        boolean status = studentService.addStudent(student);
        if (status)return new ResponseEntity<>("Student Added Successfully", HttpStatus.CREATED);
        else return new ResponseEntity<>("Student Alreday Exits", HttpStatus.ALREADY_REPORTED);
    }
    @GetMapping("/get")
    public ResponseEntity getStudentByRequestparam (@RequestParam("id") int studentId) {
        Student student = studentService.getStudentByRequestparam(studentId);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.FOUND);
        }else return new ResponseEntity<>("Student Not Exits", HttpStatus.NOT_FOUND);
    }
    @GetMapping("/get-student/{id}")
    public ResponseEntity getStudent(@PathVariable("id") int id) {
        Student student = studentService.getStudent(id);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.FOUND);
        }else return new ResponseEntity<>("Student Not Exits", HttpStatus.NOT_FOUND);

    }
    @PutMapping("/update/{id}/{c}")
    public ResponseEntity updateCourseName (@PathVariable("id") int admiId, @PathVariable("c") String courseName) {
        boolean status = studentService.updateCourseName(admiId, courseName);
        if (status) {
            return new ResponseEntity("Changes Done", HttpStatus.OK);
        }else return new ResponseEntity("Check Admission Id Wrong Once", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteStudent (@RequestParam("id") int adminNo) {
        boolean status = studentService.deleteStudent(adminNo);
        if (status) {
            return new ResponseEntity("Delete Sudent Successful", HttpStatus.OK);
        }else return new ResponseEntity("Check Addmission Number Once", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/count/{a}")
    public ResponseEntity countStudentByAge (@PathVariable("a") int age) {
        int cnt = studentService.countStudentByAge(age);
        String str = "Total Count" + cnt;
        return new ResponseEntity(str, HttpStatus.FOUND);
    }
}
