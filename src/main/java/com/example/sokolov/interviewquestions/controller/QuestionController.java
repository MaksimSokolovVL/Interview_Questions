package com.example.sokolov.interviewquestions.controller;

import com.example.sokolov.interviewquestions.domain.dto.QuestionDTO;
import com.example.sokolov.interviewquestions.domain.entity.Question;
import com.example.sokolov.interviewquestions.domain.mapper.QuestionMapper;
import com.example.sokolov.interviewquestions.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionController {


    private final QuestionMapper questionMapper;
    private final QuestionService questionService;

    public QuestionController(QuestionMapper questionMapper, QuestionService questionService) {
        this.questionMapper = questionMapper;
        this.questionService = questionService;
    }


    @GetMapping("/{id}")
    public String getQuestionsList(@PathVariable Long id, Model model) {
        List<Question> questions = questionService.getQuestionListBySectionId(id);
        List<QuestionDTO> questionDTOS = questionMapper.questionsToQuestionsDTOs(questions);
        model.addAttribute("questions", questionDTOS);

        return "questions";
    }
}
