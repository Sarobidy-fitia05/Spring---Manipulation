package com.example.demo.service;

import com.example.demo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final List<Student> studentsInMemory = new ArrayList<>();

    public List<Student> saveAll(List<Student> students) {
        this.studentsInMemory.addAll(students);
        return this.studentsInMemory;
    }
}
