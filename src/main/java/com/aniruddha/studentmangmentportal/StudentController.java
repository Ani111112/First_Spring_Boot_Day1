package com.aniruddha.studentmangmentportal;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {
    Map <Integer, Student> studentDB = new HashMap<>();
    @PostMapping("/add-student")
    public String addStudent(@RequestBody Student student) {
        if (!studentDB.containsKey(student.getAdmissionNo())) {
            studentDB.put(student.getAdmissionNo(), student);
            return "Student Added Successfully";
        }else return student.getAdmissionNo() + " Already Exits";
    }
    @GetMapping("/get")
    public Student getStudentByRequestparam (@RequestParam("id") int studentId) {
        if (studentDB.containsKey(studentId)) {
            return studentDB.get(studentId);
        }else return null;
    }
    @GetMapping("/get-student/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        if (studentDB.containsKey(id)) {
            return studentDB.get(id);
        }else return null;
    }
    @PutMapping("/update/{id}/{c}")
    public String updateCourseName (@PathVariable("id") int admiId, @PathVariable("c") String courseName) {
        if(studentDB.containsKey(admiId)) {
            Student student = studentDB.get(admiId);
            student.setCourseName(courseName);
            studentDB.put(admiId, student);
            return "Successfully Changed";
        }else return "Enter Valid Admission id";
    }

    @DeleteMapping("/delete")
    public String deleteStudent (@RequestParam("id") int adminNo) {
        if (studentDB.containsKey(adminNo)) {
            studentDB.remove(adminNo);
            return "Record Delete SuccessFully";
        }else return "Enter Valid id";
    }

    @GetMapping("/count/{a}")
    public String countStudentByAge (@PathVariable("a") int age) {
        int cnt = 0;
        for (int key : studentDB.keySet()) {
            if(studentDB.get(key).getAge() >= age)cnt++;
        }
        return "Total Count " + cnt;
    }
}
