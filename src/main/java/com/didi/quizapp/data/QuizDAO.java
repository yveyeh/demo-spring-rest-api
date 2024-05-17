package com.didi.quizapp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.didi.quizapp.model.Quiz;

@Repository
public interface QuizDAO extends JpaRepository<Quiz, Integer> {

    //
}
