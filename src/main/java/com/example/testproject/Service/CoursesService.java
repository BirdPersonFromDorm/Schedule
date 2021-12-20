package com.example.testproject.Service;

import com.example.testproject.DTO.Request.CoursesDTORequest;
import com.example.testproject.DTO.Response.CoursesDTOResponse;
import com.example.testproject.Mapper.Response.CoursesMapperResponse;
import com.example.testproject.Model.Courses;
import com.example.testproject.Repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoursesService {

    @Autowired
    CoursesRepository coursesRepository;

    @Autowired
    CoursesMapperResponse coursesMapper;

    public CoursesDTOResponse getInfo(int id){
        Optional<Courses> byId = coursesRepository.findById(id);
        return coursesMapper.mapToDTO(byId.get());
    }

    public void update(int id, CoursesDTORequest coursesDTORequest){
        Optional<Courses> byId = coursesRepository.findById(id);
        byId.get().setYear(coursesDTORequest.getYear());
        coursesRepository.save(byId.get());
    }
}
