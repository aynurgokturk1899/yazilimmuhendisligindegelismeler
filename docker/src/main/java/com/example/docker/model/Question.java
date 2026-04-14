package com.example.docker.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class Question {
    private int id;
    private String text;
    private List<Answer> answers;

    @Data
    @AllArgsConstructor
    public static class Answer {
        private String text;
        private String character; // hangi karaktere puan gider
    }
}