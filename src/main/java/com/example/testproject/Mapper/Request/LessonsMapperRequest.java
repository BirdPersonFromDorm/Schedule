package com.example.testproject.Mapper.Request;

import com.example.testproject.DTO.Request.GroupsDTORequest;
import com.example.testproject.DTO.Request.LessonsDTORequest;
import com.example.testproject.Model.Groups;
import com.example.testproject.Model.Lessons;
import org.springframework.stereotype.Component;

@Component
public class LessonsMapperRequest {

    public Lessons mapToDTO(LessonsDTORequest lessonsDTORequest) {
        Lessons lessons = new Lessons();
        lessons.setName(lessonsDTORequest.getName());
        return lessons;
    }
}
