package com.example.docker.controller;

import com.example.docker.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin(origins = "*")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/start")
    public ResponseEntity<Map<String, Object>> startQuiz() {
        return ResponseEntity.ok(quizService.startQuiz());
    }

    @PostMapping("/answer")
    public ResponseEntity<Map<String, Object>> answer(@RequestBody Map<String, Object> body) {
        String sessionId = (String) body.get("sessionId");
        int answerIndex = (Integer) body.get("answerIndex");
        return ResponseEntity.ok(quizService.answerQuestion(sessionId, answerIndex));
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Prison Break Quiz is RUNNING! 🔓");
    }
}