package com.example.Studentmanagement.ServiceImpl;

import com.example.Studentmanagement.Entity.Lesson;
import com.example.Studentmanagement.Entity.Student;
import com.example.Studentmanagement.Repository.LessonRepository;
import com.example.Studentmanagement.Service.LessonService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor


public class LessonServiceImpl implements LessonService {

    private LessonRepository lessonRepository;

    @Override
    public Lesson createLesson(Lesson lesson) {

        try {
          lessonRepository.save(lesson);
        }

        catch (Exception e){
            e.printStackTrace();
        }
        return lesson;

    }

    @Override
    public Lesson getById(int id) {

        Optional<Lesson> lessonlist=lessonRepository.findById( id);

        return lessonlist.get();
    }

    @Override
    public void deleteById(int id) {

        lessonRepository.deleteById(id);
    }

    @Override
    public List<Lesson> getAll() {
        List<Lesson> allLessons=lessonRepository.findAll();
        return allLessons;
    }

    @Override
    public Lesson updateLesson(Lesson lesson) {

        Lesson existingLesson =lessonRepository.findById(lesson.getId()).get();
        existingLesson.setTitle(lesson.getTitle());
        existingLesson.setCategory(lesson.getCategory());
        existingLesson.setClassStage(lesson.getClassStage());
        Lesson updateLesson1 =lessonRepository.save(existingLesson);



        return  updateLesson1;

    }


}
