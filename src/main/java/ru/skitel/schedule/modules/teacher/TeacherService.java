package ru.skitel.schedule.modules.teacher;

import ru.skitel.schedule.modules.base.BaseService;

import java.util.List;

public interface TeacherService extends BaseService<Teacher> {
    Teacher findById(int teacherId);
    List<Teacher> findByFacultyId(int facultyId);
}
