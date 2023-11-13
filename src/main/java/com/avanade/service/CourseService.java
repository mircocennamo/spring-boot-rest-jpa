package com.avanade.service;

import com.avanade.exception.CourseNotFoundException;
import com.avanade.model.Course;
import com.avanade.repository.CourseJpaRepository;
import com.avanade.viewmodel.CorseVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mirco.cennamo on 27/10/2023
 * @project spring-boot-rest-jpa
 */
@Service
public class CourseService {

    @Autowired
    private CourseJpaRepository repository;


    public List<CorseVm> findAll(){
        return repository.findAll().stream().map(c->CorseVm.fromModel(c)).collect(Collectors.toList());
    }

    public CorseVm findById(Long id) throws CourseNotFoundException{
        return CorseVm.fromModel(repository.findById(id).orElseThrow(() -> new CourseNotFoundException(id)));
    }

    public CorseVm save(Course course) {
        return CorseVm.fromModel(repository.save(course));
    }
}
