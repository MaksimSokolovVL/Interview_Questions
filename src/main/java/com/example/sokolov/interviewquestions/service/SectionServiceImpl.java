package com.example.sokolov.interviewquestions.service;

import com.example.sokolov.interviewquestions.domain.entity.Section;
import com.example.sokolov.interviewquestions.repository.SectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    private final SectionRepo sectionRepo;

    public SectionServiceImpl(SectionRepo sectionRepo) {
        this.sectionRepo = sectionRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Section> showAllSections() {
        return sectionRepo.findAll();
    }
}
