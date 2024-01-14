package com.example.Studentmanagement.Service;

import com.example.Studentmanagement.Entity.Lesson;

import java.util.List;

public interface LessonService {

    Lesson createLesson(Lesson lesson);

    Lesson getById(int id);

    void deleteById(int id);

    List<Lesson> getAll();

    Lesson updateLesson(Lesson lesson);

}
