package com.avanade.service;

import com.avanade.exception.CourseNotFoundException;
import com.avanade.model.Course;
import com.avanade.repository.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mirco.cennamo on 27/10/2023
 * @project spring-boot-rest-jpa
 */
@Service
public class CourseService {

    @Autowired
    private CourseJpaRepository repository;


    public List<Course> findAll(){
        return repository.findAll();
    }

    public Course findById(Long id) throws CourseNotFoundException{
        return repository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
    }

    public Course save(Course course) {
        return repository.save(course);
    }
}
