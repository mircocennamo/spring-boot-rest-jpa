package com.avanade.viewmodel;

import com.avanade.model.Course;

/**
 * @author mirco.cennamo on 08/11/2023
 * @project spring-boot-rest-jpa
 */
public record CorseVm(String name, String levelStatus) {

    public static CorseVm fromModel(Course course) {
       return new CorseVm(course.getName(), course.getLevel().name());
    }
}


