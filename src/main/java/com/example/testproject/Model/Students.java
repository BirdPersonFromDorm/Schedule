package com.example.testproject.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "students")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "students_id")
    private Integer studentsId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne()
    @JoinColumn(name = "personal_info", referencedColumnName = "personal_info_id")
    @JsonIgnoreProperties("students")
    private PersonalInfo personalInfo;


    @ManyToOne()
    @JoinColumn(name = "groups")
    @JsonIgnoreProperties("students")
    private Groups groups;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Students Students = (Students) o;

        return Objects.equals(studentsId, Students.studentsId);
    }

    @Override
    public int hashCode() {
        return studentsId != null ? studentsId.hashCode() : 0;
    }
}
