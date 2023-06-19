package com.aniruddha.studentmangmentportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    public boolean addTeacher(Teacher teacher) {
        return teacherRepository.addTeacher(teacher);
    }

    public boolean updateSubject(String subject, int teacherId) {
        return teacherRepository.updateSubject(subject, teacherId);
    }

    public Teacher getTeacher(int teacherId) {
        return teacherRepository.getTeacher(teacherId);
    }

    public int countTeacherWithSubject(int age, String subject) {
        return teacherRepository.countTeacherWithSubject(age, subject);
    }
}
