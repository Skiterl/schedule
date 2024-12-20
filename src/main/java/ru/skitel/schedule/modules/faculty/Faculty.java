package ru.skitel.schedule.modules.faculty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import ru.skitel.schedule.modules.base.BaseEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "faculty")
public class Faculty extends BaseEntity {
    @Column(name = "faculty_name", nullable = false)
    private String facultyName;

    @Column(name = "abbreviation", nullable = false)
    private String abbreviation;
}
