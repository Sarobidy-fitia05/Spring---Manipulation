package com.example.demo.Controlleur;

import com.example.demo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentTD3Cntrolleur {

    private final List<Student> studentList = new ArrayList<>();

    @GetMapping("/td3")
    public ResponseEntity<String> welcome (@RequestParam(value = "name", required = false) String name) {
        if (name == null || name.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le paramètre 'name' est obligatoire.");
            }
        return ResponseEntity.ok("Welcome " + name);
    }
    @PostMapping("/td3")
    public ResponseEntity<List<Student>> addStudents(@RequestBody List<Student> students) {
        try {
            this.studentList.addAll(students);
            return ResponseEntity.status(HttpStatus.CREATED).body(this.studentList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/td3")
    public ResponseEntity<?> getStudents(@RequestHeader(value = "Accept" , required = false) String accept) {
        try {
            if (accept == null) {
                return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            if (accept.contains("text/plain") || accept.contains("application json")) {
                return ResponseEntity.ok(this.studentList) ;
            }
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build()
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }
    }
}
