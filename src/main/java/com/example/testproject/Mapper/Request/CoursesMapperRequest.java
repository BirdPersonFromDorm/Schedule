package com.example.testproject.Mapper.Request;

import com.example.testproject.DTO.Request.CoursesDTORequest;
import com.example.testproject.DTO.Response.CoursesDTOResponse;
import com.example.testproject.Model.Courses;
import org.springframework.stereotype.Component;

@Component
public class CoursesMapperRequest {

    public Courses mapToDTO(CoursesDTORequest coursesDTORequest) {
        Courses courses = new Courses();
        courses.setYear(coursesDTORequest.getYear());
        return courses;
    }
}
