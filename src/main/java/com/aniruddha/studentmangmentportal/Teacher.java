package com.aniruddha.studentmangmentportal;

public class Teacher {
    private String name;
    private int teacherId;
    private String subjectName;
    private int age;

    public Teacher() {
    }

    public Teacher(String name, int teacherId, String subjectName, int age) {
        this.name = name;
        this.teacherId = teacherId;
        this.subjectName = subjectName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", teacherId=" + teacherId +
                ", subjectName='" + subjectName + '\'' +
                ", age=" + age +
                '}';
    }
}
