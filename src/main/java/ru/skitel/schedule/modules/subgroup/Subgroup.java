package ru.skitel.schedule.modules.subgroup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ru.skitel.schedule.modules.base.BaseEntity;
import ru.skitel.schedule.modules.group.Group;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_subgroup")
public class Subgroup extends BaseEntity {
    @Column(name = "subgroup_number", nullable = false)
    private String number;

    @ManyToOne(targetEntity = Group.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    @JsonIgnore
    private Group group;
}
