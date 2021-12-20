package com.example.testproject.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Table(name = "groups")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groups_id")
    private Integer groupsId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "groups", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("groups")
    private Set<Students> students;

    @ManyToOne
    @JoinColumn(name = "courses")
    @JsonIgnoreProperties("groups")
    private Courses courses;

    @ManyToMany(cascade=CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "groups_lessons",
            joinColumns = { @JoinColumn(name = "groups")},
            inverseJoinColumns = { @JoinColumn(name = "lessons")})
    @JsonIgnoreProperties("groups")
    private Set<Lessons> lessons;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Groups groups = (Groups) o;

        return Objects.equals(groupsId, groups.groupsId);
    }

    @Override
    public int hashCode() {
        return groupsId != null ? groupsId.hashCode() : 0;
    }

}
