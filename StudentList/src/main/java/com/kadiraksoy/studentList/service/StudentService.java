package com.kadiraksoy.studentList.service;


import com.kadiraksoy.studentList.model.Student;
import com.kadiraksoy.studentList.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student createStudent(Student newStudent) {
        Optional<Student> studentByNumber = studentRepository.findByNumber(newStudent.getNumber());
        if (studentByNumber.isPresent()){
            throw new RuntimeException("Lutfen farkli ogrenci numarasi giriniz..");
        }
        return studentRepository.save(newStudent);
    }


    public void deleteStudent(String number){
        studentRepository.deleteByNumber(number);
    }

    public Student getByNumber(String number) {
        return studentRepository.findByNumber(number)
                .orElseThrow();
    }

    public void updateStudent(String number, Student newStudent){
        Student oldStudent = getByNumber(number);
        oldStudent.setName(newStudent.getName());
        oldStudent.setEmail(newStudent.getEmail());
        oldStudent.setStudy(newStudent.getStudy());
        studentRepository.save(newStudent);
    }

}

