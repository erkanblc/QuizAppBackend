package com.example.quizapp.entity;

import jakarta.persistence.*;


@Entity
public class QuizConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int minQuestionCount;
    private int maxQuestionCount;

    public QuizConfig() {
    }

    public QuizConfig(int minQuestionCount, int maxQuestionCount) {
        this.minQuestionCount = minQuestionCount;
        this.maxQuestionCount = maxQuestionCount;
    }

    public Long getId() {
        return id;
    }

    public int getMinQuestionCount() {
        return minQuestionCount;
    }

    public void setMinQuestionCount(int minQuestionCount) {
        this.minQuestionCount = minQuestionCount;
    }

    public int getMaxQuestionCount() {
        return maxQuestionCount;
    }

    public void setMaxQuestionCount(int maxQuestionCount) {
        this.maxQuestionCount = maxQuestionCount;
    }
}
