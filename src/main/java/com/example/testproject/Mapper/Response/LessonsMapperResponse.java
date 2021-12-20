package com.example.testproject.Mapper.Response;

import com.example.testproject.DTO.Response.LessonsDTOResponse;
import com.example.testproject.Model.Lessons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class LessonsMapperResponse {

    @Autowired
    TeacherMapperResponse teacherMapper;

    public LessonsDTOResponse mapToDTO(Lessons lessons) {
        LessonsDTOResponse lessonsDTO = new LessonsDTOResponse();
        lessonsDTO.setLessonsName(lessons.getName());
        lessonsDTO.setLessonsDate(lessons.getDate());
        lessonsDTO.setLessonsTime(lessons.getTime());
        lessonsDTO.setClassRoom(lessons.getClassRoom());
        lessonsDTO.setTeacher(teacherMapper.mapToDTO(lessons.getTeacher()));

        return lessonsDTO;
    }

    public Set<LessonsDTOResponse> mapListToDTO(Set<Lessons> lessons) {
        Set<LessonsDTOResponse> listOfLessonsDTO = new HashSet<>();

        for (Lessons lesson:lessons) {
            LessonsDTOResponse lessonsDTO = new LessonsDTOResponse();
            lessonsDTO.setLessonsName(lesson.getName());
            lessonsDTO.setLessonsDate(lesson.getDate());
            lessonsDTO.setLessonsTime(lesson.getTime());
            lessonsDTO.setClassRoom(lesson.getClassRoom());
            lessonsDTO.setTeacher(teacherMapper.mapToDTO(lesson.getTeacher()));
            listOfLessonsDTO.add(lessonsDTO);
        }
        return listOfLessonsDTO;
    }

    public Set<LessonsDTOResponse> mapListToDTOForStudent(Set<Lessons> lessons, LocalDate date) {
        Set<LessonsDTOResponse> listOfLessonsDTO = new HashSet<>();

        for (Lessons lesson:lessons) {
            if (lesson.getDate().equals(date)){
                LessonsDTOResponse lessonsDTO = new LessonsDTOResponse();
                lessonsDTO.setLessonsName(lesson.getName());
                lessonsDTO.setLessonsDate(lesson.getDate());
                lessonsDTO.setLessonsTime(lesson.getTime());
                lessonsDTO.setClassRoom(lesson.getClassRoom());
                lessonsDTO.setTeacher(teacherMapper.mapToDTO(lesson.getTeacher()));
                listOfLessonsDTO.add(lessonsDTO);
            }
        }
        return listOfLessonsDTO;
    }

}
