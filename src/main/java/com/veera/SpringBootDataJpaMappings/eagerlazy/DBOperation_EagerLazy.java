package com.veera.SpringBootDataJpaMappings.eagerlazy;

import com.veera.SpringBootDataJpaMappings.entity.Book;
import com.veera.SpringBootDataJpaMappings.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DBOperation_EagerLazy
{
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void read()
    {
        // lazy loading
        Student s=entityManager.find(Student.class,3);
        List<Book> bookList=s.getBookList();
        System.out.println(s);
        System.out.println(bookList);
    }
}
