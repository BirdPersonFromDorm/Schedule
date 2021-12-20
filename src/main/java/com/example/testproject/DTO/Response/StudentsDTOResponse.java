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
public class StudentsDTOResponse {

    private String StudentsFirstName;

    private String StudentsLastName;

    private Set<LessonsDTOResponse> listOfLessons;

}
