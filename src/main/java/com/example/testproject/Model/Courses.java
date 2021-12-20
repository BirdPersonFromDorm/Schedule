package com.example.testproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Table(name = "courses")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courses_id")
    private Integer coursesId;

    @Column(name = "year")
    private int year;

    @OneToMany(mappedBy = "courses", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("courses")
    private Set<Groups> groups;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Courses courses = (Courses) o;

        return Objects.equals(coursesId, courses.coursesId);
    }

    @Override
    public int hashCode() {
        return coursesId != null ? coursesId.hashCode() : 0;
    }

}
