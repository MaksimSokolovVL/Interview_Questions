package com.example.sokolov.interviewquestions.service;

import com.example.sokolov.interviewquestions.domain.entity.Question;
import com.example.sokolov.interviewquestions.repository.QuestionRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepo questionRepo;

    public QuestionServiceImpl(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    @Override
    @Transactional
    public List<Question> getQuestionListBySectionId(Long section_id){

        return questionRepo.getQuestionListBySectionId(section_id);
    }
}
