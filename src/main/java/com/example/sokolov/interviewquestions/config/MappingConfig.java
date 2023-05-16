package com.example.sokolov.interviewquestions.config;

import com.example.sokolov.interviewquestions.domain.mapper.QuestionMapper;
import com.example.sokolov.interviewquestions.domain.mapper.SectionMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingConfig {
    @Bean
    public SectionMapper sectionMapper() {
        return Mappers.getMapper(SectionMapper.class);
    }

    @Bean
    public QuestionMapper questionMapper() {
        return Mappers.getMapper(QuestionMapper.class);
    }
}
