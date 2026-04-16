package com.example.docker.service;


import com.example.docker.data.QuizData;
import com.example.docker.model.Question;
import com.example.docker.model.QuizResult;
import com.example.docker.model.QuizSession;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class QuizService {

    private final QuizData quizData;
    private final Map<String, QuizSession> sessions = new ConcurrentHashMap<>();

    public QuizService(QuizData quizData) {
        this.quizData = quizData;
    }

    public Map<String, Object> startQuiz() {
        QuizSession session = new QuizSession();
        session.setSessionId(UUID.randomUUID().toString());
        sessions.put(session.getSessionId(), session);

        Question firstQuestion = quizData.getQuestions().get(0);
        return Map.of(
                "sessionId", session.getSessionId(),
                "question", firstQuestion,
                "questionNumber", 1,
                "totalQuestions", quizData.getQuestions().size()
        );
    }

    public Map<String, Object> answerQuestion(String sessionId, int answerIndex) {
        QuizSession session = sessions.get(sessionId);
        if (session == null) throw new RuntimeException("Session bulunamadı: " + sessionId);

        List<Question> questions = quizData.getQuestions();
        Question currentQ = questions.get(session.getCurrentQuestion());
        String chosenCharacter = currentQ.getAnswers().get(answerIndex).getCharacter();
        session.addScore(chosenCharacter);
        session.setCurrentQuestion(session.getCurrentQuestion() + 1);

        boolean finished = session.getCurrentQuestion() >= questions.size();

        if (finished) {
            String topChar = session.getTopCharacter();
            QuizData.CharacterInfo info = quizData.getCharacters().get(topChar);
            return Map.of(
                    "finished", true,
                    "result", new QuizResult(info.name(), info.description(), info.traits(), true)
            );
        }

        Question nextQ = questions.get(session.getCurrentQuestion());
        return Map.of(
                "finished", false,
                "question", nextQ,
                "questionNumber", session.getCurrentQuestion() + 1,
                "totalQuestions", questions.size()
        );
    }
}