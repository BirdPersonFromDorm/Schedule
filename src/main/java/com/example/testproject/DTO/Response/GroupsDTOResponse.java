package com.example.testproject.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GroupsDTOResponse {

    private String name;
    private Set<StudentsDTOResponse> listOfStudents;
    private int course;
    private Set<LessonsDTOResponse> listOfLessons;
}
