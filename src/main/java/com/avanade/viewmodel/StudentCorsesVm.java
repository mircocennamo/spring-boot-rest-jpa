package com.avanade.viewmodel;

import com.avanade.model.Student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mirco.cennamo on 08/11/2023
 * @project spring-boot-rest-jpa
 */
public record StudentCorsesVm(String studentName, List<String> coursesName) {

    public static StudentCorsesVm fromModel(Student student) {

        List<String> coursesName= null;

        if(student.getCourses()!=null){
            coursesName = student.getCourses().stream().map(course -> course.getName()).collect(Collectors.toList());
        }


        return new StudentCorsesVm(student.getName(), coursesName);
    }
}


