package com.example.testproject.Service;

import com.example.testproject.DTO.Request.LessonsDTORequest;
import com.example.testproject.DTO.Request.LessonsTypeDTORequest;
import com.example.testproject.DTO.Response.LessonsTypeDTOResponse;
import com.example.testproject.Mapper.Response.LessonsTypeMapperResponse;
import com.example.testproject.Model.Lessons;
import com.example.testproject.Model.LessonsType;
import com.example.testproject.Repository.LessonsTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LessonsTypeService {

    @Autowired
    LessonsTypeRepository lessonsTypeRepository;

    @Autowired
    LessonsTypeMapperResponse lessonsTypeMapper;

    public LessonsTypeDTOResponse getInfo(int id){
        Optional<LessonsType> byId = lessonsTypeRepository.findById(id);
        return lessonsTypeMapper.mapToDTO(byId.get());
    }

    public void update(int id, LessonsTypeDTORequest lessonsTypeDTORequest){
        Optional<LessonsType> byId = lessonsTypeRepository.findById(id);
        byId.get().setName(lessonsTypeDTORequest.getName());
        lessonsTypeRepository.save(byId.get());
    }
}
