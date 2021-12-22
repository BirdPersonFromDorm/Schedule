package com.example.testproject.Service;

import com.example.testproject.DTO.Request.CoursesDTORequest;
import com.example.testproject.DTO.Request.GroupsDTORequest;
import com.example.testproject.DTO.Request.LessonsDTORequest;
import com.example.testproject.DTO.Response.LessonsDTOResponse;
import com.example.testproject.Mapper.Request.LessonsMapperRequest;
import com.example.testproject.Mapper.Response.LessonsMapperResponse;
import com.example.testproject.Model.Courses;
import com.example.testproject.Model.Groups;
import com.example.testproject.Model.Lessons;
import com.example.testproject.Repository.LessonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LessonsService {

    @Autowired
    LessonsRepository lessonsRepository;

    @Autowired
    LessonsMapperResponse lessonsMapper;

    @Autowired
    LessonsMapperRequest lessonsMapperRequest;

    public LessonsDTOResponse getInfo(int id){
        Optional<Lessons> byId = lessonsRepository.findById(id);
        return lessonsMapper.mapToDTO(byId.get());
    }

    public void update(int id, LessonsDTORequest lessonsDTORequest){
        Optional<Lessons> byId = lessonsRepository.findById(id);
        byId.get().setName(lessonsDTORequest.getName());
        lessonsRepository.save(byId.get());
    }

    public void delete(int id){
        lessonsRepository.deleteById(id);
    }

    public void addNew(LessonsDTORequest lessonsDTORequest){
        Lessons lessons = lessonsMapperRequest.mapToDTO(lessonsDTORequest);
        lessonsRepository.save(lessons);
    }

}
