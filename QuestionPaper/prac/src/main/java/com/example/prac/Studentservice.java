package com.example.prac;

import org.springframework.stereotype.Service;

@Service
public class Studentservice {
    
    private final StudentReository sr;

    public Studentservice(StudentReository sr)
    {
        this.sr = sr;
    }

    public Student createStudent(Student student){
        return sr.save(student);
    }
    
}
