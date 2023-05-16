package com.example.sokolov.interviewquestions.controller;


import com.example.sokolov.interviewquestions.domain.dto.SectionDTO;
import com.example.sokolov.interviewquestions.domain.entity.Section;
import com.example.sokolov.interviewquestions.domain.mapper.SectionMapper;
import com.example.sokolov.interviewquestions.service.SectionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/section")
public class SectionApiController {

    private final SectionService sectionService;
    private final SectionMapper sectionMapper;

    public SectionApiController(
            SectionService sectionService,
            SectionMapper sectionMapper
    ) {
        this.sectionService = sectionService;
        this.sectionMapper = sectionMapper;
    }


    @GetMapping
    public List<SectionDTO> showAllSections() {
        List<Section> sections = sectionService.showAllSections();
        return sectionMapper.sectionsToSectionDTOs(sections);
    }
}
