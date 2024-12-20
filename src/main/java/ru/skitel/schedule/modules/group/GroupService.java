package ru.skitel.schedule.modules.group;

import ru.skitel.schedule.modules.base.BaseService;
import ru.skitel.schedule.modules.record.ScheduleRecord;

import java.util.List;

public interface GroupService extends BaseService<Group> {
    Group findById(int id);
    Group findByNumber(String number);
    List<Group> findByUserId(int userId);
}
