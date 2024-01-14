package com.example.Studentmanagement.Service;


import com.example.Studentmanagement.Entity.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Student getById(int Id);
    Student updateStudent(Student student);
    void deleteById(int Id);
    List<Student> getAll();
}
