package com.example.testproject.Service;

import com.example.testproject.DTO.Request.CoursesDTORequest;
import com.example.testproject.DTO.Response.CoursesDTOResponse;
import com.example.testproject.Mapper.Request.CoursesMapperRequest;
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

    @Autowired
    CoursesMapperRequest coursesMapperRequest;

    public CoursesDTOResponse getInfo(int id){
        Optional<Courses> byId = coursesRepository.findById(id);
        return coursesMapper.mapToDTO(byId.get());
    }

    public void update(int id, CoursesDTORequest coursesDTORequest){
        Optional<Courses> byId = coursesRepository.findById(id);
        byId.get().setYear(coursesDTORequest.getYear());
        coursesRepository.save(byId.get());
    }

    public void delete(int id){
        coursesRepository.deleteById(id);
    }

    public void addNew(CoursesDTORequest coursesDTORequest){
        Courses courses = coursesMapperRequest.mapToDTO(coursesDTORequest);
        coursesRepository.save(courses);
    }
}
