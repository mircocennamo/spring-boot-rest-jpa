package com.avanade.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany
    Set<Student> students;

    public Course(String name) {
        this.name = name;
    }
}
