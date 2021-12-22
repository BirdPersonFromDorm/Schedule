package com.example.testproject.DTO.Request;

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
public class PersonalInfoDTORequest {

    private String email;
    private String address;
    private int age;
    private String telephoneNumber;

}
