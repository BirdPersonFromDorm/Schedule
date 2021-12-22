package com.example.testproject.Mapper.Request;

import com.example.testproject.DTO.Request.StudentsDTORequest;
import com.example.testproject.DTO.Request.TeacherDTORequest;
import com.example.testproject.Model.Students;
import com.example.testproject.Model.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapperRequest {

    public Teacher mapToDTO(TeacherDTORequest teacherDTORequest) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherDTORequest.getFirstName());
        teacher.setLastName(teacherDTORequest.getLastName());
        teacher.setPersonalInfo(teacherDTORequest.getPersonalInfo());
        return teacher;
    }
}
