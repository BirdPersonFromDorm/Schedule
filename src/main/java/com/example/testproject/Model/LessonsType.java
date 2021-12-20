package com.example.testproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Table(name = "lessons_type")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LessonsType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lessons_type_id")
    private Integer lessonsTypeId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "lessonsType", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("lessons_type")
    private Set<Lessons> lessons;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LessonsType lessonsType = (LessonsType) o;

        return Objects.equals(lessonsTypeId, lessonsType.lessonsTypeId);
    }

    @Override
    public int hashCode() {
        return lessonsTypeId != null ? lessonsTypeId.hashCode() : 0;
    }

}
