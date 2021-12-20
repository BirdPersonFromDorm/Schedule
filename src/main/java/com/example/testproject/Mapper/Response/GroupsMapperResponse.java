package com.example.testproject.Mapper.Response;

import com.example.testproject.DTO.Response.GroupsDTOResponse;
import com.example.testproject.Model.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GroupsMapperResponse {

    @Autowired
    LessonsMapperResponse lessonsMapper;

    @Autowired
    StudentsMapperResponse studentsMapper;

    public GroupsDTOResponse mapToDTO(Groups groups) {
        GroupsDTOResponse groupsDTO = new GroupsDTOResponse();
        groupsDTO.setName(groups.getName());
        groupsDTO.setCourse(groups.getCourses().getYear());
        groupsDTO.setListOfLessons(lessonsMapper.mapListToDTO(groups.getLessons()));
        groupsDTO.setListOfStudents(studentsMapper.mapListToDTO(groups.getStudents()));
        return groupsDTO;
    }
}
