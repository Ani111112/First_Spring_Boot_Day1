package com.aniruddha.studentmangmentportal;

public class Student {
    private int admissionNo;
    private String name;
    private int age;
    private String courseName;
    private int mobNo;

    public Student() {
    }

    public Student(int admissionNo, String name, int age, String courseName, int mobNo) {
        this.admissionNo = admissionNo;
        this.name = name;
        this.age = age;
        this.courseName = courseName;
        this.mobNo = mobNo;
    }

    public int getAdmissionNo() {
        return admissionNo;
    }

    public void setAdmissionNo(int admissionNo) {
        this.admissionNo = admissionNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getMobNo() {
        return mobNo;
    }

    public void setMobNo(int mobNo) {
        this.mobNo = mobNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "admissionNo=" + admissionNo +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", courseName='" + courseName + '\'' +
                ", mobNo=" + mobNo +
                '}';
    }
}
