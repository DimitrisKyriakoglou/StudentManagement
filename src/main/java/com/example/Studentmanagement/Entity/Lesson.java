package com.example.Studentmanagement.Entity;


import jakarta.persistence.*;
import lombok.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lesson")
public class Lesson {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String category;
    @Column (nullable = false)
    private String classStage;





}
