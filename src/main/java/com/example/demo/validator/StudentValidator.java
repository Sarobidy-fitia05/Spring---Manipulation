package com.example.demo.validator;

import com.example.demo.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentValidator {
    public void validate(Student student) {
        if (student.getRef() == null || student.getRef().isBlank()){
            throw new RuntimeException("NewStudent.reference cannot be null");
        }
        if (student.getFirstname() == null || student.getFirstname().isBlank()){
            throw new RuntimeException("NewStudent.firstname cannot be null");
        }

    }
}
