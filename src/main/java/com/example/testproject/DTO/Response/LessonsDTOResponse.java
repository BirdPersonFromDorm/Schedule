package com.example.testproject.DTO.Response;


import com.fasterxml.jackson.annotation.JsonFormat;
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
public class LessonsDTOResponse {

    private String lessonsName;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate lessonsDate;

    private String lessonsTime;

    private int classRoom;

    private TeacherDTOResponse teacher;
}
