package com.didi.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.didi.quizapp.data.QuestionDAO;
import com.didi.quizapp.model.Question;

@Service
public class QuestionService {

    public QuestionService() {
        //
    }

    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDAO.save(question);
            return new ResponseEntity<>("Question added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Question>> getAllQuestions() { 
        // Does no processing but rather fetches data from the database via the DAO
        try {
            return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Question> getQuestionByID(Integer id) {
        if (id == null || id <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    
        try {
            return questionDAO.findById(id)
                    .map(question -> new ResponseEntity<>(question, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDAO.findByCategory(category);
    }

    public String updateQuestion(Integer id, Question updatedQuestion) {
        Optional<Question> optionalQuestion = questionDAO.findById(id);
        if (optionalQuestion.isPresent()) {
            Question questionToUpdate = optionalQuestion.get();
            // Update fields of the existing question object with the fields of the updated question
            questionToUpdate.setQuestionTitle(updatedQuestion.getQuestionTitle());
            questionToUpdate.setOption1(updatedQuestion.getOption1());
            questionToUpdate.setOption2(updatedQuestion.getOption2());
            questionToUpdate.setOption3(updatedQuestion.getOption3());
            questionToUpdate.setOption4(updatedQuestion.getOption4());
            questionToUpdate.setRightAnswer(updatedQuestion.getRightAnswer());
            questionToUpdate.setDifficultyLevel(updatedQuestion.getDifficultyLevel());
            questionToUpdate.setCategory(updatedQuestion.getCategory());
            // Save the updated question to the database
            questionDAO.save(questionToUpdate);
            return "Success";
        } else {
            return "Question not found";
        }
    }

    public String deleteQuestion(Integer id) {
        questionDAO.deleteById(id);
        return "Success";
    }
}
