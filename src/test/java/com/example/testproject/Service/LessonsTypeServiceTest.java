package com.example.testproject.Service;

import com.example.testproject.DTO.Response.CoursesDTOResponse;
import com.example.testproject.DTO.Response.LessonsTypeDTOResponse;
import com.example.testproject.Mapper.Request.CoursesMapperRequest;
import com.example.testproject.Model.Courses;
import com.example.testproject.Model.LessonsType;
import com.example.testproject.Repository.CoursesRepository;
import com.example.testproject.Repository.LessonsTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class LessonsTypeServiceTest {

    @Autowired
    LessonsTypeService lessonsTypeService;

    @MockBean
    LessonsTypeRepository lessonsTypeRepository;


    @Test
    void getInfo() {
        LessonsType lessonsType = new LessonsType();
        lessonsType.setName("Test");

        Optional<LessonsType> lessonsType1 = Optional.of(lessonsType);

        given(this.lessonsTypeRepository.findById(1)).willReturn(lessonsType1);

        LessonsTypeDTOResponse info = lessonsTypeService.getInfo(1);

        assertNotNull(info);

    }

}