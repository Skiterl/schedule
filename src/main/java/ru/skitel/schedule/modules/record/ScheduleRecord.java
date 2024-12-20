package ru.skitel.schedule.modules.record;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.skitel.schedule.modules.subgroup.Subgroup;
import ru.skitel.schedule.modules.subject.Subject;
import ru.skitel.schedule.modules.teacher.Teacher;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "schedule_record")
public class ScheduleRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "parity")
    private String parity;

    @ManyToOne(targetEntity = Subgroup.class)
    @JoinColumn(name = "subgroup_id", nullable = false)
    private Subgroup subgroup;

    @ManyToOne(targetEntity = Subject.class)
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @ManyToOne(targetEntity = Teacher.class)
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @Column(name = "day_week")
    private String dayWeek;

    @Column(name = "time_start")
    private String timeStart;

    @Column(name = "time_end")
    private String timeEnd;

    @Column(name = "classroom")
    private String classroom;
}