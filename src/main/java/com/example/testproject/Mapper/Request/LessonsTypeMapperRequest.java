package com.example.testproject.Mapper.Request;

import com.example.testproject.DTO.Request.LessonsDTORequest;
import com.example.testproject.DTO.Request.LessonsTypeDTORequest;
import com.example.testproject.Model.Lessons;
import com.example.testproject.Model.LessonsType;
import org.springframework.stereotype.Component;

@Component
public class LessonsTypeMapperRequest {

    public LessonsType mapToDTO(LessonsTypeDTORequest lessonsTypeDTORequest) {
        LessonsType lessonsType = new LessonsType();
        lessonsType.setName(lessonsTypeDTORequest.getName());
        return lessonsType;
    }
}
