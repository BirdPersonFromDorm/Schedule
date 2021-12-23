package com.example.testproject.Mapper.Response;

import com.example.testproject.DTO.Response.LessonsTypeDTOResponse;
import com.example.testproject.DTO.Response.PersonalInfoDTOResponse;
import com.example.testproject.Model.LessonsType;
import com.example.testproject.Model.PersonalInfo;
import org.springframework.stereotype.Component;

@Component
public class PersonalInfoMapperResponse {
    public PersonalInfoDTOResponse mapToDTO(PersonalInfo personalInfo) {
        PersonalInfoDTOResponse personalInfoDTOResponse = new PersonalInfoDTOResponse();
        personalInfoDTOResponse.setPersonalInfoAge(personalInfo.getAge());
        personalInfoDTOResponse.setPersonalInfoAdres(personalInfo.getAddress());
        personalInfoDTOResponse.setPersonalInfoEmail(personalInfo.getEmail());
        personalInfoDTOResponse.setPersonalInfoTelephoneNumber(personalInfo.getTelephoneNumber());

        return personalInfoDTOResponse;
    }

}

