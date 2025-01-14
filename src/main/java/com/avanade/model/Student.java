package com.avanade.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
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
public class Student extends BaseEntity {



    @NotNull
    private String name;

    @NotNull
    private String passportNumber;



    @ManyToMany(cascade = { CascadeType.MERGE})
    Set<Course> courses;

    public Student(String name, String passportNumber) {
        this.name = name;
        this.passportNumber = passportNumber;
    }


}
