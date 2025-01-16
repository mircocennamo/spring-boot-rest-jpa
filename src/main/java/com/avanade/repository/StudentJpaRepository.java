package com.avanade.repository;

import com.avanade.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentJpaRepository extends JpaRepository<Student, Long> {

    List<Student> findByPassportNumber(String passportNumber);

}
