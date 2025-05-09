package com.example.quizapp.service;

import com.example.quizapp.entity.Question;
import com.example.quizapp.repository.QuestionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository repo;

    public QuestionService(QuestionRepository repo) {
        this.repo = repo;
    }

    public List<Question> getAll() {
        return repo.findAll();
    }

    public Optional<Question> getById(Long id) {
        return repo.findById(id);
    }

    public Question save(Question question) {
        return repo.save(question);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Question> saveAll(List<Question> questions) {
        return repo.saveAll(questions);
    }

    //Retrieves a list of random questions from the database
    public List<Question> getRandomQuestions(int count){
        return repo.findRandomQuestions(count);
    }
}
