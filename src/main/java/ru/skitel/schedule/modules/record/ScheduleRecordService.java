package ru.skitel.schedule.modules.record;

import ru.skitel.schedule.modules.base.BaseService;
import ru.skitel.schedule.modules.subgroup.Subgroup;

import java.util.List;
import java.util.Set;

public interface ScheduleRecordService extends BaseService<ScheduleRecord> {
    ScheduleRecord findById(int id);
    List<ScheduleRecord> findBySubgroups(List<Subgroup> subgroups);
    List<ScheduleRecord> findByGroupId(int GroupId);
    List<ScheduleRecord> findBySubgroupId(int SubgroupId);
}