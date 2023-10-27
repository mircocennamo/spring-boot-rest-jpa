package com.avanade.service;

import com.avanade.exception.CourseNotFoundException;
import com.avanade.exception.StudentNotFoundException;
import com.avanade.model.Student;
import com.avanade.repository.StudentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mirco.cennamo on 27/10/2023
 * @project spring-boot-rest-jpa
 */
@Service
public class StudentService {

    @Autowired
    private StudentJpaRepository repository;


    public List<Student> findAll(){
        return repository.findAll();
    }

    public Student findById(Long id) throws CourseNotFoundException{
        return repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student save(Student student) {
        return repository.save(student);
    }
}
