package com.veera.SpringBootDataJpaMappings.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name="book")
public class Book
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="subject_name")
    private String subjectName;

    @Column(name="edition")
    private int edition;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="student_id")
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book() {
    }

    public Book(String subjectName, int edition) {
        this.subjectName = subjectName;
        this.edition = edition;

    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                ", edition=" + edition +
                ", student=" + student +
                '}';
    }
}
