package com.kadiraksoy.studentList.repository;

import com.kadiraksoy.studentList.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student , String > {


    Optional<Student> findByNumber(int number);





}
