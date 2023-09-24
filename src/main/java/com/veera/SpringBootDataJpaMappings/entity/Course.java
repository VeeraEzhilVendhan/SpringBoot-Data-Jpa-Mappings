package com.veera.SpringBootDataJpaMappings.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="course")
public class Course
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="course_name")
    private String courseName;

    @Column(name="duration_weeks")
    private int durationWeeks;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name="student_course", joinColumns = @JoinColumn(name="course_id"),inverseJoinColumns = @JoinColumn(name="student_id"))
    private List<Student> studentList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getDurationWeeks() {
        return durationWeeks;
    }

    public void setDurationWeeks(int durationWeeks) {
        this.durationWeeks = durationWeeks;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Course() {
    }

    public Course(String courseName, int durationWeeks) {
        this.courseName = courseName;
        this.durationWeeks = durationWeeks;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", durationWeeks=" + durationWeeks +
                ", studentList=" + studentList +
                '}';
    }
}
