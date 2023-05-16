package com.example.sokolov.interviewquestions.repository;

import com.example.sokolov.interviewquestions.domain.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepo extends JpaRepository<Section, Long> {

}
