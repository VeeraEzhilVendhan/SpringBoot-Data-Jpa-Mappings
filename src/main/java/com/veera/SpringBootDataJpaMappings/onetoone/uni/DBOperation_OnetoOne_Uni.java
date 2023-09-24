package com.veera.SpringBootDataJpaMappings.onetoone.uni;

import com.veera.SpringBootDataJpaMappings.entity.Student;
import com.veera.SpringBootDataJpaMappings.entity.Student_Profile;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DBOperation_OnetoOne_Uni
{
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void save()
    {
        Student_Profile s_profile = new Student_Profile("reading","cricket");
        Student s = new Student("john","male","5","john@gmail.com");
        s.setStudentProfile(s_profile);
        entityManager.persist(s);
    }

    @Transactional
    public void read()
    {
       Student s=entityManager.find(Student.class,1);
       Student_Profile sp= s.getStudentProfile();
       System.out.println(sp);
    }
}
