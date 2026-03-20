package com.example.demo.Controlleur;

import com.example.demo.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentControlleur {
    private final List<Student> studentList = new ArrayList<>();
    @PostMapping("/students")
    public String addStudent(@RequestBody List<Student> students) {
        this.studentList.addAll(students);
        return studentList.stream()
                .map(s -> "REF :" + s.getRef() + ", "+
                        "Nom : " + s.getLastname() + ", "+
                        "prénom : "+ s.getFirstname()+ ", "+
                        "Age: "+ s.getAge()  )
                .collect(Collectors.joining(" |  "));
    }
     @GetMapping("/students")
    public String getStudent (@RequestHeader("Accept") String accept) {
         if ("text/plain".equals(accept)) {
             return studentList.stream()
                     .map(s -> s.getFirstname() + " " + s.getLastname())
                     .collect(Collectors.joining(", "));
         } else {
             return "Format non supporté";
         }
     }

}
