package com.aniruddha.studentmangmentportal;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TeacherRepository {
    Map<Integer, Teacher> teacherDB = new HashMap<>();
    public boolean addTeacher(Teacher teacher) {
        if (!teacherDB.containsKey(teacher.getTeacherId())) {
            //add the in the db
            teacherDB.put(teacher.getTeacherId(), teacher);
            return true;
        }else return false;
    }

    public boolean updateSubject(String subject, int teacherId) {
        //update the subject if id matches any teacher id any he/she takes another subject
        if (teacherDB.containsKey(teacherId)) {
            if (!subject.equals(teacherDB.get(teacherId).getSubjectName())) {
                Teacher teacher = teacherDB.get(teacherId);
                teacher.setSubjectName(subject);
                return true;
            }else throw new RuntimeException("Subject is same");
        }else return false;
    }

    public Teacher getTeacher(int teacherId) {
        if (teacherDB.containsKey(teacherId)) {
            return teacherDB.get(teacherId);
        }else return null;
    }

    public int countTeacherWithSubject(int age, String subject) {
        int cnt = 0;
        for (int key : teacherDB.keySet()) {
            int teacherAge = teacherDB.get(key).getAge();
            String sub = teacherDB.get(key).getSubjectName();
            if (teacherAge >= age && sub.equals(subject)) {
                cnt++;
            }
        }
        return cnt;
    }
}
