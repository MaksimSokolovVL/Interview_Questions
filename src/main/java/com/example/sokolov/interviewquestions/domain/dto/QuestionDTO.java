package com.example.sokolov.interviewquestions.domain.dto;

import com.example.sokolov.interviewquestions.domain.entity.Answer;
import com.example.sokolov.interviewquestions.domain.entity.Section;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {

        private Long id;
        private String text;
        private byte[] image;
        private String explanation;
        private Section section;
        private List<Answer> answers;
}
