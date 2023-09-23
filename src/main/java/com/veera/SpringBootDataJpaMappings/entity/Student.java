package com.veera.SpringBootDataJpaMappings.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="gender")
    private String gender;

    @Column(name="grade")
    private String grade;

    @Column(name="email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="student_profile_id")
    private Student_Profile studentProfile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Student_Profile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(Student_Profile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public Student() {
    }

    public Student(String name, String gender, String grade, String email) {
        this.name = name;
        this.gender = gender;
        this.grade = grade;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", grade='" + grade + '\'' +
                ", email='" + email + '\'' +
                ", studentProfile=" + studentProfile +
                '}';
    }
}
