package com.example.testproject.Service;

import com.example.testproject.DTO.Request.StudentsDTORequest;
import com.example.testproject.DTO.Request.TeacherDTORequest;
import com.example.testproject.DTO.Response.TeacherDTOResponse;
import com.example.testproject.Mapper.Request.TeacherMapperRequest;
import com.example.testproject.Mapper.Response.TeacherMapperResponse;
import com.example.testproject.Model.Students;
import com.example.testproject.Model.Teacher;
import com.example.testproject.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TeacherMapperResponse teacherMapper;

    @Autowired
    TeacherMapperRequest teacherMapperRequest;

    public TeacherDTOResponse getInfo(int id){
        Optional<Teacher> byId = teacherRepository.findById(id);
        return teacherMapper.mapToDTO(byId.get());
    }

    public void update(int id, TeacherDTORequest teacherDTORequest){
        Optional<Teacher> byId = teacherRepository.findById(id);
        byId.get().setLastName(teacherDTORequest.getLastName());
        teacherRepository.save(byId.get());
    }

    public void delete(int id){
        teacherRepository.deleteById(id);
    }

    public void addNew(TeacherDTORequest teacherDTORequest){
        Teacher teacher = teacherMapperRequest.mapToDTO(teacherDTORequest);
        teacherRepository.save(teacher);
    }
}
