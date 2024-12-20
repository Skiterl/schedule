package ru.skitel.schedule.modules.faculty;

import ru.skitel.schedule.modules.base.BaseService;

public interface FacultyService extends BaseService<Faculty> {
    Faculty findById(int facultyId);
}
