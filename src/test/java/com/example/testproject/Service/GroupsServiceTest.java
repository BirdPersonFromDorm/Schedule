package com.example.testproject.Service;

import com.example.testproject.DTO.Response.CoursesDTOResponse;
import com.example.testproject.DTO.Response.GroupsDTOResponse;
import com.example.testproject.Mapper.Request.CoursesMapperRequest;
import com.example.testproject.Mapper.Request.GroupsMapperRequest;
import com.example.testproject.Model.Courses;
import com.example.testproject.Model.Groups;
import com.example.testproject.Repository.CoursesRepository;
import com.example.testproject.Repository.GroupsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class GroupsServiceTest {

    @Autowired
    GroupsService groupsService;

    @MockBean
    GroupsRepository groupsRepository;

    @MockBean
    GroupsMapperRequest groupsMapperRequest;

    @Test
    void getInfo() {
        Groups groupsTest = new Groups();
        groupsTest.setGroupsId(1);
        groupsTest.setName("PCC-20");

        Optional<Groups> groups = Optional.of(groupsTest);

        given(this.groupsRepository.findById(1)).willReturn(groups);

        GroupsDTOResponse info = groupsService.getInfo(1);

        assertNotNull(info);
        assertEquals("PCC-20", info.getName());
    }
}