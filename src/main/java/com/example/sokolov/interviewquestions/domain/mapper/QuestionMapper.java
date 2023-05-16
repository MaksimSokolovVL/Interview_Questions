package com.example.sokolov.interviewquestions.domain.mapper;

import com.example.sokolov.interviewquestions.domain.dto.QuestionDTO;

import com.example.sokolov.interviewquestions.domain.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.List;


@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    QuestionDTO questionToQuestionDTO(Question question);

    List<QuestionDTO> questionsToQuestionsDTOs(List<Question> questions);
}
