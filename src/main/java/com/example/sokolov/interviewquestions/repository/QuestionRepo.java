package com.example.sokolov.interviewquestions.repository;

import com.example.sokolov.interviewquestions.domain.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question, Long> {


    @Query("select q from Question q inner join q.section s where s.id = ?1")
    List<Question> getQuestionListBySectionId(Long section_id);
}
