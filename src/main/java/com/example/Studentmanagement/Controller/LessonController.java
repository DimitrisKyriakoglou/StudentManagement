package com.example.Studentmanagement.Controller;



import com.example.Studentmanagement.Entity.Lesson;


import com.example.Studentmanagement.Service.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/lessons")

public class LessonController {
    private LessonService lessonService;



    //GET ALL
    //http://localhost:8080/api/students
    @GetMapping
    public ResponseEntity<List<Lesson>>  getAllLessons(){
        List<Lesson> allLessons = lessonService.getAll();
        return new ResponseEntity<>(allLessons,HttpStatus.OK);
    }


    //Get Lesson by id
    @GetMapping("{id}")
    public ResponseEntity<Lesson> getLessonsById ( @PathVariable("id")  int  id){
        Lesson lesson= lessonService.getById(id);
        return new ResponseEntity<>(lesson,HttpStatus.OK);
    }
    //create Lesson

    @PostMapping
    public ResponseEntity<Lesson> createLesson(@RequestBody Lesson lesson){
        Lesson saveLesson= lessonService.createLesson(lesson);
        return new ResponseEntity<>(saveLesson, HttpStatus.CREATED);
    }



    //Update Lesson
    @PutMapping("{id}")
    public ResponseEntity<Lesson> updateLessonsById ( @PathVariable("id")  int  id ,@RequestBody Lesson lesson)   {
       lesson.setId(id);
      Lesson lessonUpdate = lessonService.updateLesson(lesson);
        return new ResponseEntity<>(lessonUpdate,HttpStatus.OK);
    }


    //Delete Lesson
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLessonsById ( @PathVariable("id")  int  id )   {
        lessonService.deleteById(id);
        return new ResponseEntity<>("Lesson Deleted",HttpStatus.OK);
    }



}
