package com.example.quizapp.service;

import com.example.quizapp.entity.QuizConfig;
import com.example.quizapp.repository.QuizConfigRepository;
import org.springframework.stereotype.Service;

@Service
public class QuizConfigService {

    private final QuizConfigRepository configRepo;


    public QuizConfigService(QuizConfigRepository configRepo) {
        this.configRepo = configRepo;
    }

    public QuizConfig getConfig() {
        return configRepo.findById(1L).orElseGet(() -> {
            System.out.println("UYARI: Varsayılan yapı kullanılmalı.");
            return null;
        });
    }

    public QuizConfig updateConfig(QuizConfig updated) {
        QuizConfig existing = getConfig();

        //null object check
        if (existing == null) {
            System.out.println("UYARI: QuizConfig güncellenemedi çünkü veri bulunamadı.");
            return null;
        }

        existing.setMinQuestionCount(updated.getMinQuestionCount());
        existing.setMaxQuestionCount(updated.getMaxQuestionCount());
        return configRepo.save(existing);
    }
}
