package com.example.quizapp.controller;

import com.example.quizapp.entity.QuizConfig;
import com.example.quizapp.service.QuizConfigService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/config")
@CrossOrigin(origins = "*")
public class QuizConfigController {

    private final QuizConfigService configService;

    public QuizConfigController(QuizConfigService configService) {
        this.configService = configService;
    }

    @GetMapping
    public QuizConfig getConfig(){
        return configService.getConfig();
    }

    @PutMapping
    public QuizConfig updateConfig(@RequestBody QuizConfig updated){
        return configService.updateConfig(updated);
    }
}
