package com.example.testproject.Mapper.Request;

import com.example.testproject.DTO.Request.LessonsTypeDTORequest;
import com.example.testproject.DTO.Request.StudentsDTORequest;
import com.example.testproject.Model.LessonsType;
import com.example.testproject.Model.Students;
import org.springframework.stereotype.Component;

@Component
public class StudentsMapperRequest {

    public Students mapToDTO(StudentsDTORequest studentsDTORequest) {
        Students students = new Students();
        students.setLastName(studentsDTORequest.getLastName());
        return students;
    }
}
