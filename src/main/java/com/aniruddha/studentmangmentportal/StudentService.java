package com.aniruddha.studentmangmentportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public boolean addStudent(Student student) {
        boolean status = studentRepository.addStudent(student);
        if (status)return true;
        return false;
    }

    public Student getStudentByRequestparam(int studentId) {
        return studentRepository.getStudentByRequestparam(studentId);
    }

    public Student getStudent(int id) {
        return studentRepository.getStudent(id);
    }

    public boolean updateCourseName(int admiId, String courseName) {
        return studentRepository.updateCourseName(admiId, courseName);
    }

    public boolean deleteStudent(int adminNo) {
        return studentRepository.deleteStudent(adminNo);
    }

    public int countStudentByAge(int age) {
        return studentRepository.countStudentByAge(age);
    }
}
