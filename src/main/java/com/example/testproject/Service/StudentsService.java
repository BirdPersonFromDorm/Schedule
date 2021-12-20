package com.example.testproject.Service;

import com.example.testproject.DTO.Request.PersonalInfoDTORequest;
import com.example.testproject.DTO.Request.StudentsDTORequest;
import com.example.testproject.DTO.Response.StudentsDTOResponse;
import com.example.testproject.Mapper.Response.StudentsMapperResponse;
import com.example.testproject.Model.PersonalInfo;
import com.example.testproject.Model.Students;
import com.example.testproject.Repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentsService {

    @Autowired
    StudentsRepository studentsRepository;

    @Autowired
    StudentsMapperResponse studentsMapper;

    public StudentsDTOResponse getInfo(int id){
        Optional<Students> byId = studentsRepository.findById(id);
        return studentsMapper.mapToDTO(byId.get());
    }

    public List<StudentsDTOResponse> getLessonsByStudents(String lastName){
        List<Students> all = studentsRepository.findByLastName(lastName);
        List<StudentsDTOResponse> studentsDTO = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            studentsDTO.add(studentsMapper.mapToDTOOnlyForStudents(all.get(i)));
        }
        return studentsDTO;
    }

    public List<StudentsDTOResponse> getLessonsByStudentsAndDate(String lastName, String date){
        List<Students> all = studentsRepository.findByLastName(lastName);
        LocalDate localDate = LocalDate.parse(date);

        return all.stream()
                .map(x -> studentsMapper.mapToDTOForStudentWithDate(x, localDate))
                .collect(Collectors.toList());
    }

    public void update(int id, StudentsDTORequest studentsDTORequest){
        Optional<Students> byId = studentsRepository.findById(id);
        byId.get().setLastName(studentsDTORequest.getLastName());
        studentsRepository.save(byId.get());
    }

}
