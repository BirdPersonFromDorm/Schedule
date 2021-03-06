package com.example.testproject.Service;

import com.example.testproject.DTO.Request.LessonsTypeDTORequest;
import com.example.testproject.DTO.Request.PersonalInfoDTORequest;
import com.example.testproject.DTO.Response.PersonalInfoDTOResponse;
import com.example.testproject.Mapper.Request.PersonalInfoMapperRequest;
import com.example.testproject.Mapper.Response.PersonalInfoMapperResponse;
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

    @Autowired
    PersonalInfoMapperResponse personalInfoMapperResponse;

    @Autowired
    PersonalInfoMapperRequest personalInfoMapperRequest;


    public PersonalInfoDTOResponse getInfo(int id){
        Optional<PersonalInfo> byId = personalInfoRepository.findById(id);
        return personalInfoMapperResponse.mapToDTO(byId.get());
    }

    public void update(int id, PersonalInfoDTORequest personalInfoDTORequest){
        Optional<PersonalInfo> byId = personalInfoRepository.findById(id);
        byId.get().setEmail(personalInfoDTORequest.getEmail());
        personalInfoRepository.save(byId.get());
    }

    public void delete(int id){
        personalInfoRepository.deleteById(id);
    }

    public void addNew(PersonalInfoDTORequest personalInfoDTORequest){
        PersonalInfo personalInfo = personalInfoMapperRequest.mapToDTO(personalInfoDTORequest);
        personalInfoRepository.save(personalInfo);
    }
}
