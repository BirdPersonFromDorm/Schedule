package com.example.testproject.DTO.Request;

import com.example.testproject.Model.Groups;
import com.example.testproject.Model.PersonalInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentsDTORequest {

    private String firstName;
    private String lastName;
    private Groups groups;
    private PersonalInfo personalInfo;
}
