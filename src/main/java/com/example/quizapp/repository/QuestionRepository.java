package com.example.quizapp.repository;

import com.example.quizapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionRepository extends JpaRepository <Question, Long>  {

@Query(value = "SELECT * FROM question ORDER BY RAND() LIMIT :count", nativeQuery = true)
List<Question> findRandomQuestions(@Param("count") int count);

}
