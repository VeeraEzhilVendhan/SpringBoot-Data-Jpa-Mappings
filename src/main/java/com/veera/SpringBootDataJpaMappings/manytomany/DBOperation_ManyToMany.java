package com.veera.SpringBootDataJpaMappings.manytomany;

import com.veera.SpringBootDataJpaMappings.entity.Course;
import com.veera.SpringBootDataJpaMappings.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DBOperation_ManyToMany
{
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void save()
    {
        Student s1=new Student("john","male","6","john@gmail.com");
        Student s2=new Student("varun","male","6","varun@gmail.com");
        Student s3=new Student("arun","male","6","arun@gmail.com");

        Course c1=new Course("computer_science",6);
        Course c2=new Course("game_development",4);
        Course c3=new Course("graphic_designing",3);

        List<Student> studentList=new ArrayList<>();
        studentList.add(s1); studentList.add(s2); studentList.add(s3);

//        List<Course> courseList=new ArrayList<>();
//        courseList.add(c1); courseList.add(c2); courseList.add(c3);

        c1.setStudentList(studentList); c2.setStudentList(studentList); c3.setStudentList(studentList);

        entityManager.persist(c1); entityManager.persist(c2); entityManager.persist(c3);


    }
}
