package com.example.Studentmanagement.Repository;

import com.example.Studentmanagement.Entity.Lesson;
import com.example.Studentmanagement.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson,Integer> {
}
