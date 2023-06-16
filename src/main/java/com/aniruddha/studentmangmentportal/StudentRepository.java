package com.aniruddha.studentmangmentportal;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<Integer, Student> studentDB = new HashMap<>();

    public boolean addStudent(Student student) {
        if (!studentDB.containsKey(student.getAdmissionNo())) {
            studentDB.put(student.getAdmissionNo(), student);
            return true;
        }else return false;
    }

    public Student getStudentByRequestparam(int studentId) {
        if (studentDB.containsKey(studentId)) {
            return studentDB.get(studentId);
        }else return null;
    }

    public Student getStudent(int id) {
        if (studentDB.containsKey(id)) {
            return studentDB.get(id);
        }else return null;
    }

    public boolean updateCourseName(int admiId, String courseName) {
        if(studentDB.containsKey(admiId)) {
            Student student = studentDB.get(admiId);
            student.setCourseName(courseName);
            studentDB.put(admiId, student);
            return true;
        }else return false;
    }

    public boolean deleteStudent(int adminNo) {
        if (studentDB.containsKey(adminNo)) {
            studentDB.remove(adminNo);
            return true;
        }else return false;
    }

    public int countStudentByAge(int age) {
        int cnt = 0;
        for (int key : studentDB.keySet()) {
            if(studentDB.get(key).getAge() >= age)cnt++;
        }
        return cnt;
    }
}
