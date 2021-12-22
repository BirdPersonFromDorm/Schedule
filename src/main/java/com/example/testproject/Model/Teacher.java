package com.example.testproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Table(name = "teacher")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Integer teacherId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne()
    @JoinColumn(name = "personal_info", referencedColumnName = "personal_info_id")
    @JsonIgnoreProperties("teacher")
    private PersonalInfo personalInfo;


    @OneToMany(mappedBy = "teacher", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("teacher")
    private Set<Lessons> lessons;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        return Objects.equals(teacherId, teacher.teacherId);
    }

    @Override
    public int hashCode() {
        return teacherId != null ? teacherId.hashCode() : 0;
    }
}
