package com.example.testproject.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Table(name = "lessons")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lessons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lessons_id")
    private Integer lessonsId;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date;

    @Column(name = "time")
    private String time;

    @Column(name = "class_room")
    private int classRoom;

    @ManyToOne
    @JoinColumn(name = "lessons_type")
    @JsonIgnoreProperties("lessons")
    private LessonsType lessonsType;

    @ManyToOne
    @JoinColumn(name = "teacher")
    @JsonIgnoreProperties("lessons")
    private Teacher teacher;

    @ManyToMany(mappedBy = "lessons")
    Set<Groups> groups;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lessons lessons = (Lessons) o;

        return Objects.equals(lessonsId, lessons.lessonsId);
    }

    @Override
    public int hashCode() {
        return lessonsId != null ? lessonsId.hashCode() : 0;
    }
}
