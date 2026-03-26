package com.example.demo.Controlleur;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.example.demo.validator.StudentValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentControlleur {
    private final List<Student> studentList = new ArrayList<>();
    private final StudentService studentService;
    private final StudentValidator studentValidator;

    public StudentControlleur(StudentService studentService, StudentValidator studentValidator) {
        this.studentService = studentService;
        this.studentValidator = studentValidator;
    }

    //    @PostMapping("/students")
//    public String addStudent(@RequestBody List<Student> students) {
//        this.studentList.addAll(students);
//        return studentList.stream()
//                .map(s -> "REF :" + s.getRef() + ", "+
//                        "Nom : " + s.getLastname() + ", "+
//                        "prénom : "+ s.getFirstname()+ ", "+
//                        "Age: "+ s.getAge()  )
//                .collect(Collectors.joining(" |  "));
//    }
//    @GetMapping("/students")
//    public String getStudent (@RequestHeader("Accept") String accept) {
//        if ("text/plain".equals(accept)) {
//            return studentList.stream()
//                    .map(s -> s.getFirstname() + " " + s.getLastname())
//                    .collect(Collectors.joining(", "));
//        } else {
//            return "Format non supporté";
//        }
//    }
//@GetMapping("/welcome")
//public ResponseEntity<String> td3 (@RequestParam(value = "name", required = false) String name) {
//    if (name == null || name.isEmpty()){
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le paramètre 'name' est obligatoire.");
//    }
//    return ResponseEntity.ok("Welcome " + name);
//}
//    @PostMapping("/students")
//    public ResponseEntity<List<Student>> addStudentsTD3(@RequestBody List<Student> students) {
//        try {
//            this.studentList.addAll(students);
//            return ResponseEntity.status(HttpStatus.CREATED).body(this.studentList);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }

    @GetMapping("/students")
    public ResponseEntity<?> getStudentsTd3(@RequestHeader(value = "Accept" , required = false) String accept) {
        try {
            if (accept == null) {
                return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            if (accept.contains("text/plain") || accept.contains("application json")) {
                return ResponseEntity.ok(this.studentList) ;
            }
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("/students")
    public ResponseEntity<?> createStudents(@RequestBody List<Student> students) {
        try {
            for (Student s : students) {
                studentValidator.validate(s);
            }
            List<Student> savedStudents = studentService.saveAll(students);
            return ResponseEntity.ok(savedStudents);
        }catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}