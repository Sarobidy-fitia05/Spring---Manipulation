package com.example.demo.validator;

import com.example.demo.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StudentValidator {
    private static final Logger log = LoggerFactory.getLogger(StudentValidator.class);

    public void validate(Student student) {
        if (student.getRef() == null || student.getRef().isBlank()){
            throw new RuntimeException("NewStudent.reference cannot be null");
        }
        if (student.getFirstname() == null || student.getFirstname().isBlank()){
            throw new RuntimeException("NewStudent.firstname cannot be null");
        }
        if (student.getLastname() == null || student.getLastname().isBlank()){
            throw new RuntimeException("NewStudent.Lasttname cannot be null");
        }

    }
}
