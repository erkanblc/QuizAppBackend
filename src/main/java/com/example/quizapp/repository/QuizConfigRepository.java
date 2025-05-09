package com.example.quizapp.repository;

import com.example.quizapp.entity.QuizConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizConfigRepository extends JpaRepository<QuizConfig,Long> {
}
