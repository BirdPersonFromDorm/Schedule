package com.example.testproject.Mapper.Request;

import com.example.testproject.DTO.Request.CoursesDTORequest;
import com.example.testproject.DTO.Request.GroupsDTORequest;
import com.example.testproject.Model.Courses;
import com.example.testproject.Model.Groups;
import org.springframework.stereotype.Component;

@Component
public class GroupsMapperRequest {

    public Groups mapToDTO(GroupsDTORequest groupsDTORequest) {
        Groups groups = new Groups();
        groups.setName(groupsDTORequest.getName());
        return groups;
    }
}
