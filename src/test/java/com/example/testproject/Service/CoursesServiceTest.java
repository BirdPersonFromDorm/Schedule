package com.example.testproject.Service;

import com.example.testproject.DTO.Request.CoursesDTORequest;
import com.example.testproject.DTO.Response.CoursesDTOResponse;
import com.example.testproject.Mapper.Request.CoursesMapperRequest;
import com.example.testproject.Mapper.Response.CoursesMapperResponse;
import com.example.testproject.Model.Courses;
import com.example.testproject.Repository.CoursesRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class CoursesServiceTest{

    @Autowired
    CoursesService coursesService;

    @MockBean
    CoursesRepository coursesRepository;

    @MockBean
    CoursesMapperRequest coursesMapperRequest;

    @Test
    void getInfo() {
        Courses coursesTest = new Courses();
        coursesTest.setCoursesId(1);
        coursesTest.setYear(2021);

        Optional<Courses> courses1 = Optional.of(coursesTest);

        given(this.coursesRepository.findById(1)).willReturn(courses1);

        CoursesDTOResponse info = coursesService.getInfo(1);

        assertNotNull(info);
        assertEquals(2021, info.getYear());
    }
}