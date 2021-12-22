package com.example.testproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "personal_info")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personal_info_id")
    private Integer personalInfoId;

    @Column(name = "email")
    private String email;

    @Column(name = "adress")
    private String address;

    @Column(name = "age")
    private int age;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    @OneToOne(mappedBy = "personalInfo")
    @JsonIgnoreProperties("personalInfo")
    private Students students;

    @OneToOne(mappedBy = "personalInfo")
    @JsonIgnoreProperties("personalInfo")
    private Teacher teacher;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonalInfo personalInfo = (PersonalInfo) o;

        return Objects.equals(personalInfoId, personalInfo.personalInfoId);
    }

    @Override
    public int hashCode() {
        return personalInfoId != null ? personalInfoId.hashCode() : 0;
    }
}
