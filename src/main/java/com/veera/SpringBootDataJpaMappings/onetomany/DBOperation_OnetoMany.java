package com.veera.SpringBootDataJpaMappings.onetomany;

import com.veera.SpringBootDataJpaMappings.entity.Book;
import com.veera.SpringBootDataJpaMappings.entity.Student;
import com.veera.SpringBootDataJpaMappings.entity.Student_Profile;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DBOperation_OnetoMany
{
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void save()
    {
        Book b1=new Book("maths",2014);
        Book b2=new Book("science",2014);
        Book b3=new Book("english",2014);
        Student_Profile s_p1=new Student_Profile("reading","cricket");
        Student s1=new Student("john","male","6","john@gmail.com");
        s1.setStudentProfile(s_p1);
        s1.addBook(b1);
        s1.addBook(b2);
        s1.addBook(b3);
        entityManager.persist(s1);
    }

    @Transactional
    public void read()
    {
        Student s=entityManager.find(Student.class,3);
        System.out.println(s);
        System.out.println(s.getStudentProfile());
        System.out.println(s.getBookList());
    }
}
