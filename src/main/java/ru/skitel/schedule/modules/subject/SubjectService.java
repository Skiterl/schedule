package ru.skitel.schedule.modules.subject;

import ru.skitel.schedule.modules.base.BaseService;

public interface SubjectService extends BaseService<Subject> {
    Subject findById(int subjectId);
}
