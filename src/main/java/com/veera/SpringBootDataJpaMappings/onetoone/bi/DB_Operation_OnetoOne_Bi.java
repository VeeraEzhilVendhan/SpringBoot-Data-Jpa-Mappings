package com.veera.SpringBootDataJpaMappings.onetoone.bi;

import com.veera.SpringBootDataJpaMappings.entity.Student;
import com.veera.SpringBootDataJpaMappings.entity.Student_Profile;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DB_Operation_OnetoOne_Bi
{
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void save()
    {
        Student_Profile s_profile = new Student_Profile("reading","cricket");
        Student s = new Student("john","male","5","john@gmail.com");
        s_profile.setStudent(s);
        entityManager.persist(s_profile);
    }

    @Transactional
    public void read()
    {
        Student_Profile sp=entityManager.find(Student_Profile.class,3);
        Student s=sp.getStudent();
        System.out.println(s);
    }
}
