package com.avanade.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Course extends BaseEntity{



    @NotNull
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    @NotNull
    private LevelStatus level;

    public Course(String name) {
        this.name = name;
    }


}
