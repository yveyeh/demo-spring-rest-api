package com.didi.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.didi.quizapp.data.QuestionDAO;
import com.didi.quizapp.data.QuizDAO;
import com.didi.quizapp.model.Question;
import com.didi.quizapp.model.Quiz;

@Service
public class QuizService {

    @Autowired
    private QuizDAO quizDAO;

    @Autowired
    private QuestionDAO questionDAO;

    public ResponseEntity<String> createQuiz(String category, int numberOfQuestions, String title) {

        List<Question> questions = questionDAO.findRandomQuestions(category, numberOfQuestions);

        Quiz quiz = new Quiz();

        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizDAO.save(quiz);

        return new ResponseEntity<>("Quiz successfully created", HttpStatus.CREATED);
    }

}
