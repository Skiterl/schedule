package ru.skitel.schedule.modules.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skitel.schedule.modules.teacher.Teacher;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    public Optional<List<Teacher>> findByFacultyId(int facultyId);
}
