package ru.skitel.schedule.modules.teacher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skitel.schedule.modules.teacher.Teacher;
import ru.skitel.schedule.modules.teacher.TeacherRepository;
import ru.skitel.schedule.modules.teacher.TeacherService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    @Override
    public Teacher insert(Teacher entity) {
        return teacherRepository.save(entity);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public Teacher findById(int teacherId) {
        return teacherRepository.findById(teacherId).orElseThrow();
    }

    @Override
    public List<Teacher> findByFacultyId(int facultyId) {
        return teacherRepository.findByFacultyId(facultyId).orElseThrow();
    }
}
