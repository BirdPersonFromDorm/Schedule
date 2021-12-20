package com.example.testproject.Mapper.Response;

import com.example.testproject.DTO.Response.TeacherDTOResponse;
import com.example.testproject.Model.Teacher;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class TeacherMapperResponse {


    public TeacherDTOResponse mapToDTO(Teacher teacher) {
        TeacherDTOResponse teacherDTO = new TeacherDTOResponse();
        teacherDTO.setTeacherFirstName(teacher.getFirstName());
        teacherDTO.setTeacherLastName(teacher.getLastName());

        return teacherDTO;
    }


    public Set<TeacherDTOResponse> mapListToDTO(Set<Teacher> teachers) {

        Set<TeacherDTOResponse> listOfTeacherDTO = new HashSet<>();

        for (Teacher teacher:teachers) {
            TeacherDTOResponse teacherDTO = new TeacherDTOResponse();
            teacherDTO.setTeacherFirstName(teacher.getFirstName());
            teacherDTO.setTeacherLastName(teacher.getLastName());
            listOfTeacherDTO.add(teacherDTO);
        }

        return listOfTeacherDTO;
    }
}
