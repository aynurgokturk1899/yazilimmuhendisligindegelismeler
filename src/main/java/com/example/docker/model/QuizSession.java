package com.example.docker.model;


import lombok.Data;
import java.util.HashMap;
import java.util.Map;

@Data
public class QuizSession {
    private String sessionId;
    private int currentQuestion = 0;
    private Map<String, Integer> scores = new HashMap<>();

    public void addScore(String character) {
        scores.merge(character, 1, Integer::sum);
    }

    public String getTopCharacter() {
        return scores.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("MICHAEL");
    }
}