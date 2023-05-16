package com.example.sokolov.interviewquestions.service;

import com.example.sokolov.interviewquestions.domain.entity.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestionListBySectionId(Long section_id);
}
