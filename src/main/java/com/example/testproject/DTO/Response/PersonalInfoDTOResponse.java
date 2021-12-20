package com.example.testproject.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonalInfoDTOResponse {


    private String personalInfoEmail;

    private String personalInfoAdres;

    private String personalInfoAge;

    private String personalInfoTelephoneNumber;
}
