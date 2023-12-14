package com.example.springquizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springquizapp.model.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
