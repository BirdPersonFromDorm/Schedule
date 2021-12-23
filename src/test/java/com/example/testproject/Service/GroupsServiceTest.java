package com.example.testproject.Service;

import com.example.testproject.DTO.Response.CoursesDTOResponse;
import com.example.testproject.DTO.Response.GroupsDTOResponse;
import com.example.testproject.DTO.Response.LessonsDTOResponse;
import com.example.testproject.DTO.Response.StudentsDTOResponse;
import com.example.testproject.Mapper.Request.CoursesMapperRequest;
import com.example.testproject.Mapper.Request.GroupsMapperRequest;
import com.example.testproject.Mapper.Response.GroupsMapperResponse;
import com.example.testproject.Model.Courses;
import com.example.testproject.Model.Groups;
import com.example.testproject.Model.Lessons;
import com.example.testproject.Model.Students;
import com.example.testproject.Repository.CoursesRepository;
import com.example.testproject.Repository.GroupsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class GroupsServiceTest {

    @Autowired
    GroupsService groupsService;

    @MockBean
    GroupsRepository groupsRepository;

    @MockBean
    GroupsMapperRequest groupsMapperRequest;

    @MockBean
    GroupsMapperResponse groupsMapperResponse;


    @Test
    void testGetByName() {
        Groups groups = new Groups();
        groups.setName("PCC-20");

        List<Groups> groupsList = new ArrayList<>();
        groupsList.add(groups);

        given(this.groupsRepository.findByName("PCC-20")).willReturn(groupsList);

        List<GroupsDTOResponse> info = groupsService.getByName("PCC-20");

        assertEquals(1, info.size());
    }

}