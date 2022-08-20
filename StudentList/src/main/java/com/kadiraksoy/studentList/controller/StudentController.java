package com.kadiraksoy.studentList.controller;

import com.kadiraksoy.studentList.model.Student;
import com.kadiraksoy.studentList.service.StudentService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor

public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(@RequestParam(required = false) String number){
        return new ResponseEntity<>(studentService.getStudents(number), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@PathVariable String number, @RequestBody Student newStudent){
        return new ResponseEntity<>(studentService.createStudent(newStudent),HttpStatus.CREATED);
    }

    @PutMapping("/{number}")
    public ResponseEntity<Void> upgradeStudent(@PathVariable String number, @RequestBody Student newStudent){
        studentService.updateStudent(number, newStudent);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{number}")
    public  ResponseEntity<Void> deleteStudent(@PathVariable String number){
        studentService.deleteStudent(number);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
