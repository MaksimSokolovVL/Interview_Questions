package com.example.sokolov.interviewquestions.domain.mapper;

import com.example.sokolov.interviewquestions.domain.dto.SectionDTO;
import com.example.sokolov.interviewquestions.domain.entity.Section;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper(componentModel = "spring")
public interface SectionMapper {

        SectionMapper INSTANCE = Mappers.getMapper(SectionMapper.class);
        @Mapping(target = "questions", ignore = true)
        SectionDTO sectionToSectionDTO(Section section);

        List<SectionDTO> sectionsToSectionDTOs(List<Section> sections);
}
