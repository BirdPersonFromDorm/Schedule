package com.example.testproject.Service;

import com.example.testproject.DTO.Response.GroupsDTOResponse;
import com.example.testproject.DTO.Response.StudentsDTOResponse;
import com.example.testproject.Mapper.Request.GroupsMapperRequest;
import com.example.testproject.Mapper.Request.StudentsMapperRequest;
import com.example.testproject.Mapper.Response.GroupsMapperResponse;
import com.example.testproject.Mapper.Response.StudentsMapperResponse;
import com.example.testproject.Model.Groups;
import com.example.testproject.Model.Students;
import com.example.testproject.Repository.GroupsRepository;
import com.example.testproject.Repository.StudentsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class StudentsServiceTest {

    @Autowired
    StudentsService studentsService;

    @MockBean
    StudentsRepository studentsRepository;

    @MockBean
    StudentsMapperRequest studentsMapperRequest;

    @MockBean
    StudentsMapperResponse studentsMapperResponse;

    @Test
    void getLessonsByStudents() {
        Students students = new Students();
        students.setLastName("Test");

        List<Students> students1 = new ArrayList<>();
        students1.add(students);

        given(this.studentsRepository.findByLastName("Test")).willReturn(students1);

        List<StudentsDTOResponse> test = studentsService.getLessonsByStudents("Test");

        assertEquals(1, test.size());
    }


}