package com.example.testproject.Mapper.Request;

import com.example.testproject.DTO.Request.PersonalInfoDTORequest;
import com.example.testproject.Model.PersonalInfo;
import org.springframework.stereotype.Component;

@Component
public class PersonalInfoMapperRequest {

    public PersonalInfo mapToDTO(PersonalInfoDTORequest personalInfoDTORequest) {
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setEmail(personalInfoDTORequest.getEmail());
        personalInfo.setAddress(personalInfoDTORequest.getAddress());
        personalInfo.setAge(personalInfoDTORequest.getAge());
        personalInfo.setTelephoneNumber(personalInfoDTORequest.getTelephoneNumber());
        return personalInfo;
    }
}
