package com.example.testproject.Service;

import com.example.testproject.DTO.Response.LessonsTypeDTOResponse;
import com.example.testproject.Model.LessonsType;
import com.example.testproject.Model.PersonalInfo;
import com.example.testproject.Repository.LessonsTypeRepository;
import com.example.testproject.Repository.PersonalInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class PersonalInfoServiceTest {

    @Autowired
    PersonalInfoService personalInfoService;

    @MockBean
    PersonalInfoRepository personalInfoRepository;

    @Test
    void getInfo() {
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setEmail("test@mail.com");

        given(this.personalInfoRepository.findById(1)).willReturn(Optional.of(personalInfo));


        assertNotNull(personalInfoService.getInfo(1));
    }

}