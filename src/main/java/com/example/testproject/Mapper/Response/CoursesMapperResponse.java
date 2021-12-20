package com.example.testproject.Mapper.Response;

import com.example.testproject.DTO.Response.CoursesDTOResponse;
import com.example.testproject.Model.Courses;
import org.springframework.stereotype.Component;

@Component
public class CoursesMapperResponse {

    public CoursesDTOResponse mapToDTO(Courses courses) {
        CoursesDTOResponse coursesDTO = new CoursesDTOResponse();
        coursesDTO.setYear(courses.getYear());
        return coursesDTO;
    }
}
