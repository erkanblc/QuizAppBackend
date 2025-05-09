package com.example.quizapp.controller;

import com.example.quizapp.entity.Question;
import com.example.quizapp.entity.QuizConfig;
import com.example.quizapp.service.QuestionService;
import com.example.quizapp.service.QuizConfigService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "*")
public class QuestionController {

    private final QuestionService questionService;
    private final QuizConfigService quizConfigService;

    public QuestionController(QuestionService questionService, QuizConfigService quizConfigService) {
        this.questionService = questionService;
        this.quizConfigService = quizConfigService;
    }

    @GetMapping
    public List<Question> getAll() {
        return questionService.getAll();
    }

    @GetMapping("/{id}")
    public Question getById(@PathVariable Long id) {
        return questionService.getById(id).orElseThrow();
    }

    @PostMapping
    public Question create(@RequestBody Question question) {
        return questionService.save(question);
    }

    @PutMapping("/{id}")
    public Question update(@PathVariable Long id, @RequestBody Question updated) {
        Question existing = questionService.getById(id).orElseThrow();
        existing.setText(updated.getText());
        existing.setOptions(updated.getOptions());
        existing.setCorrectAnswer(updated.getCorrectAnswer());
        return questionService.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        questionService.delete(id);
    }


    //Adds a batch of new questions to the database.
    @PostMapping("/batch")
    public List<Question> createBatch(@RequestBody List<Question> questions) {
        return questionService.saveAll(questions);
    }


    //random?count=2
    @GetMapping("/random")
    public List<Question> getRandomQuestions(@RequestParam(defaultValue = "3") int count){
        QuizConfig quizConfig = quizConfigService.getConfig();
        if(quizConfig != null){
            int minQuestion = quizConfig.getMinQuestionCount();
            int maxQuestion = quizConfig.getMaxQuestionCount();

//            if (count <= 0) {
//                System.out.println("Hata: Negatif veya sıfır değerli count parametresi geçersiz. Varsayılan 1 olarak ayarlanıyor.");
//                count = minQuestion;
//            }

            if (count < minQuestion) {
                System.out.println("Uyarı: İstenen soru sayısı min sınırının altında. " + minQuestion + " olarak ayarlanıyor.");
                count = minQuestion;
            } else if (count > maxQuestion) {
                System.out.println("Uyarı: İstenen soru sayısı max sınırın üstünde. " + maxQuestion + " olarak ayarlanıyor.");
                count = maxQuestion;
            }
        }

        return questionService.getRandomQuestions(count);
    }
}
