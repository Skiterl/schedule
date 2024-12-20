package ru.skitel.schedule.modules.teacher;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.skitel.schedule.modules.faculty.Faculty;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teacher", uniqueConstraints = { @UniqueConstraint(columnNames = {"name", "post"}) })
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "post")
    private String post;

    @ManyToOne(targetEntity = Faculty.class)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;
}