package com.example.prac;


import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentReository extends JpaRepository<Student,Long> {

}
