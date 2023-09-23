package com.veera.SpringBootDataJpaMappings.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student_profile")
public class Student_Profile
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="hobby")
    private String hobby;

    @Column(name="fav_sport")
    private String fav_sport;

    // bi-directional mapping

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH},mappedBy = "studentProfile")
    private Student student;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getFav_sport() {
        return fav_sport;
    }

    public void setFav_sport(String fav_sport) {
        this.fav_sport = fav_sport;
    }

    public Student_Profile() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student_Profile(String hobby, String fav_sport) {
        this.hobby = hobby;
        this.fav_sport = fav_sport;
    }

    @Override
    public String toString() {
        return "Student_Profile{" +
                "id=" + id +
                ", hobby='" + hobby + '\'' +
                ", fav_sport='" + fav_sport + '\'' +
                '}';
    }
}
