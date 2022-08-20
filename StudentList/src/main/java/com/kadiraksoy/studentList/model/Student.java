package com.kadiraksoy.studentList.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    @Id
    int number;

    String name;

    String study;

    String email;

}
