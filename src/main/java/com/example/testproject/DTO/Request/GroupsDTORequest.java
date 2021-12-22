package com.example.testproject.DTO.Request;

import com.example.testproject.Model.Courses;
import com.example.testproject.Model.Lessons;
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
public class GroupsDTORequest {

    private String name;
    private Courses course;
    private Set<Lessons> lessons;
}
