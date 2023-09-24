package com.veera.SpringBootDataJpaMappings.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(cascade=CascadeType.ALL,mappedBy = "student")
    private List<Book> bookList;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name="student_course", joinColumns = @JoinColumn(name="student_id"),inverseJoinColumns = @JoinColumn(name="course_id"))
    private List<Course> courseList;


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
                ", bookList=" + bookList +
                ", courseList=" + courseList +
                '}';
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void addBook(Book b)
    {
        if(bookList==null)
        {
            bookList=new ArrayList<>();
        }
        bookList.add(b);
        b.setStudent(this);
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
