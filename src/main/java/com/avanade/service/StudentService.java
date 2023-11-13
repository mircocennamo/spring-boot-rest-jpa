package com.avanade.service;

import com.avanade.exception.CourseNotFoundException;
import com.avanade.exception.StudentNotFoundException;
import com.avanade.model.Student;
import com.avanade.repository.StudentJpaRepository;
import com.avanade.viewmodel.StudentCorsesVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mirco.cennamo on 27/10/2023
 * @project spring-boot-rest-jpa
 */
@Service
public class StudentService {

    @Autowired
    private StudentJpaRepository repository;


    public List<StudentCorsesVm> findAll(){

        return  repository.findAll().stream().map(s->StudentCorsesVm.fromModel(s)).collect(Collectors.toList());

    }

    public StudentCorsesVm findById(Long id) throws CourseNotFoundException{
        return StudentCorsesVm.fromModel(repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id)));
    }

    public StudentCorsesVm save(Student student) {
        return  StudentCorsesVm.fromModel(repository.save(student));
    }
}
