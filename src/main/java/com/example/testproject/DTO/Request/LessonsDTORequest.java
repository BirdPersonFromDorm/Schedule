package com.example.testproject.DTO.Request;

import com.example.testproject.Model.LessonsType;
import com.example.testproject.Model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LessonsDTORequest {

    private String name;
    private LocalDate date;
    private String time;
    private int classRoom;
    private Teacher teacher;
    private LessonsType lessonsType;

}
