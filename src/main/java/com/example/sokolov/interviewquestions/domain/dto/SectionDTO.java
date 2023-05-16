package com.example.sokolov.interviewquestions.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SectionDTO {
        private Long id;
        private String sectionName;
        private List<QuestionDTO> questions;
}
