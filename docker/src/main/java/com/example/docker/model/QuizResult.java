package com.example.docker.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuizResult {
    private String character;
    private String description;
    private String imageHint;
    private boolean finished;
}