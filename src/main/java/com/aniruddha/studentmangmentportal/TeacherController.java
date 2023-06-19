package com.aniruddha.studentmangmentportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @PostMapping("/add_teacher")
    public ResponseEntity addTeacher (@RequestBody Teacher teacher) {
        boolean status = teacherService.addTeacher(teacher);
        if (status) {
            return new ResponseEntity<>("Teacher Added SuccessFully", HttpStatus.CREATED);
        }else return new ResponseEntity<>("TeacherId already Exits", HttpStatus.ALREADY_REPORTED);
    }

    @GetMapping("/get-teacher")
    public ResponseEntity getTeacher(@RequestParam("id") int teacherId) {
        Teacher teacher = teacherService.getTeacher(teacherId);
        if (teacher != null) {
            return new ResponseEntity<>(teacher, HttpStatus.FOUND);
        }else return new ResponseEntity<>("Teacher Does not Exits", HttpStatus.NOT_FOUND);
    }
    @PutMapping("/update_subject/{s}/{id}")
    public ResponseEntity updateSubject(@PathVariable("s") String subject, @PathVariable("id") int teacherId) {
        boolean status = teacherService.updateSubject(subject, teacherId);
        if (status) {
            return new ResponseEntity<>("Subject Change Successfully", HttpStatus.OK);
        }else return new ResponseEntity<>("TeacherId is Incorrect", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/count-techer/{a}/{s}")
    public ResponseEntity countTeacherWithSubject(@PathVariable("a") int age, @PathVariable("s") String subject) {
        int res = teacherService.countTeacherWithSubject(age, subject);
        return new ResponseEntity<>("Toatl Count" + res, HttpStatus.OK);
    }
}
