package com.example.Studentmanagement.Controller;

import com.example.Studentmanagement.Entity.Student;
import com.example.Studentmanagement.Service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/students")

public class StudentController {

    private StudentService studentService;

    //create student

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student saveStudent=studentService.createStudent(student);
    return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);
    }

    //get user by id
    //http://localhost:8080/api/students/1
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentsById ( @PathVariable("id")  int  id){
        Student student = studentService.getById(id);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    //GET ALL
    //http://localhost:8080/api/students
    @GetMapping
    public ResponseEntity<List<Student>>  getAllStudents (){
        List<Student> allStudents = studentService.getAll();
        return new ResponseEntity<>(allStudents,HttpStatus.OK);
    }

    //Delete by id
    //http://localhost:8080/api/students/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudentsById ( @PathVariable("id")  int  id){
        studentService.deleteById(id);
        return new ResponseEntity<>("Student successfully deleted",HttpStatus.OK);
    }


    //Update by id
    //http://localhost:8080/api/students/1
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudentsById ( @PathVariable("id")  int  id ,@RequestBody Student student)   {
        student.setId(id);
        Student studentUpdate = studentService.updateStudent(student);
        return new ResponseEntity<>(studentUpdate,HttpStatus.OK);
    }






}
