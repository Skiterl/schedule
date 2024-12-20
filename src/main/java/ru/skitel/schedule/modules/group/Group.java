package ru.skitel.schedule.modules.group;

import jakarta.persistence.*;
import lombok.*;
import ru.skitel.schedule.modules.base.BaseEntity;
import ru.skitel.schedule.modules.faculty.Faculty;
import ru.skitel.schedule.modules.subgroup.Subgroup;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_group")
public class Group extends BaseEntity {
    @Column(name = "number", unique = true)
    private String number;

    @Column(name = "direction")
    private String direction;

    @Column(name = "profile")
    private String profile;

    @ManyToOne(targetEntity = Faculty.class)
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subgroup> subgroups;
}
