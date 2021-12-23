package com.example.testproject.Service;

import com.example.testproject.DTO.Response.GroupsDTOResponse;
import com.example.testproject.DTO.Response.LessonsDTOResponse;
import com.example.testproject.Mapper.Request.GroupsMapperRequest;
import com.example.testproject.Mapper.Request.LessonsMapperRequest;
import com.example.testproject.Model.Groups;
import com.example.testproject.Model.Lessons;
import com.example.testproject.Repository.GroupsRepository;
import com.example.testproject.Repository.LessonsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class LessonsServiceTest {

    @Test
    void getInfo() {

    }
}