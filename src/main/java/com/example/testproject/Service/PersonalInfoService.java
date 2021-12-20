package com.example.testproject.Service;

import com.example.testproject.DTO.Request.LessonsTypeDTORequest;
import com.example.testproject.DTO.Request.PersonalInfoDTORequest;
import com.example.testproject.Model.LessonsType;
import com.example.testproject.Model.PersonalInfo;
import com.example.testproject.Repository.PersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonalInfoService {

    @Autowired
    PersonalInfoRepository personalInfoRepository;


    public PersonalInfo getInfo(int id){
        Optional<PersonalInfo> byId = personalInfoRepository.findById(id);
        PersonalInfo personalInfo = byId.get();
        return personalInfo;
    }

    public void update(int id, PersonalInfoDTORequest personalInfoDTORequest){
        Optional<PersonalInfo> byId = personalInfoRepository.findById(id);
        byId.get().setEmail(personalInfoDTORequest.getEmail());
        personalInfoRepository.save(byId.get());
    }
}
