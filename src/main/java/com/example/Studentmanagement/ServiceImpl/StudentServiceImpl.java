package com.example.Studentmanagement.ServiceImpl;


import com.example.Studentmanagement.Entity.Student;
import com.example.Studentmanagement.Repository.StudentRepository;
import com.example.Studentmanagement.Service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class StudentServiceImpl implements StudentService {


    private StudentRepository studentRepository;

    //Create
    @Override
    public  Student createStudent(Student student) {

        try {
            studentRepository.save(student);
        }

        catch (Exception e){
            e.printStackTrace();
        }
        return student;

    }
    @Override
    public Student getById(int id) {

        Optional<Student> studentlist=studentRepository.findById( id);


        return studentlist.get();
    }

    //Update
    @Override
    public Student updateStudent(Student student) {
        Student existingStudent =studentRepository.findById(student.getId()).get();
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setGrade(student.getGrade());
        Student updateStudent =studentRepository.save(existingStudent);



        return  updateStudent;
    }

    //Delete
    @Override
    public void deleteById(int id) {


        studentRepository.deleteById(id);
    }





    @Override
    public List<Student> getAll(){
        List<Student> studentListAll= studentRepository.findAll();

        return studentListAll;
    }




}
