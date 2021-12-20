package com.example.testproject.Mapper.Response;

import com.example.testproject.DTO.Response.StudentsDTOResponse;
import com.example.testproject.Model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class StudentsMapperResponse {

    @Autowired
    LessonsMapperResponse lessonsMapper;

    public StudentsDTOResponse mapToDTO(Students students) {
        StudentsDTOResponse studentsDTO = new StudentsDTOResponse();
        studentsDTO.setStudentsFirstName(students.getFirstName());
        studentsDTO.setStudentsLastName(students.getLastName());
        return studentsDTO;
    }


    public Set<StudentsDTOResponse> mapListToDTO(Set<Students> students) {
        Set<StudentsDTOResponse> listOfStudentsDTO = new HashSet<>();

        for (Students student:students) {
            StudentsDTOResponse studentsDTO = new StudentsDTOResponse();
            studentsDTO.setStudentsFirstName(student.getFirstName());
            studentsDTO.setStudentsLastName(student.getLastName());
            listOfStudentsDTO.add(studentsDTO);
        }
        return listOfStudentsDTO;
    }

    public StudentsDTOResponse mapToDTOOnlyForStudents(Students students){
        StudentsDTOResponse studentsDTO = new StudentsDTOResponse();
        studentsDTO.setStudentsFirstName(students.getFirstName());
        studentsDTO.setStudentsLastName(students.getLastName());
        studentsDTO.setListOfLessons(lessonsMapper.mapListToDTO(students.getGroups().getLessons()));
        return studentsDTO;
    }

    public StudentsDTOResponse mapToDTOForStudentWithDate(Students students, LocalDate date){
        StudentsDTOResponse studentsDTO = new StudentsDTOResponse();
        studentsDTO.setStudentsFirstName(students.getFirstName());
        studentsDTO.setStudentsLastName(students.getLastName());
        studentsDTO.setListOfLessons(lessonsMapper.mapListToDTOForStudent(students.getGroups().getLessons(), date));
        return studentsDTO;
    }
}
