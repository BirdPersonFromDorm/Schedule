package com.example.testproject.Mapper.Response;

import com.example.testproject.DTO.Response.LessonsTypeDTOResponse;
import com.example.testproject.Model.LessonsType;
import org.springframework.stereotype.Component;

@Component
public class LessonsTypeMapperResponse {

    public LessonsTypeDTOResponse mapToDTO(LessonsType lessonsType) {
        LessonsTypeDTOResponse lessonsTypeDTO = new LessonsTypeDTOResponse();
        lessonsTypeDTO.setLessonsTypeName(lessonsType.getName());

        return lessonsTypeDTO;
    }
}
