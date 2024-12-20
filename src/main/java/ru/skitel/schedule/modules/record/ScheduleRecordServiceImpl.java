package ru.skitel.schedule.modules.record;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skitel.schedule.modules.group.GroupRepository;
import ru.skitel.schedule.modules.subgroup.Subgroup;
import ru.skitel.schedule.modules.subgroup.SubgroupRepository;
import ru.skitel.schedule.modules.subgroup.SubgroupService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleRecordServiceImpl implements ScheduleRecordService {
    private final ScheduleRecordRepository scheduleRecordRepository;
    private final SubgroupRepository subgroupRepository;

    @Override
    public ScheduleRecord insert(ScheduleRecord entity) {
        return scheduleRecordRepository.save(entity);
    }

    @Override
    public List<ScheduleRecord> getAll() {
        return scheduleRecordRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        scheduleRecordRepository.deleteById(id);
    }

    @Override
    public ScheduleRecord findById(int id) {
        return scheduleRecordRepository.findById(id).orElseThrow();
    }

    @Override
    public List<ScheduleRecord> findBySubgroups(List<Subgroup> subgroups) {
        return subgroups.stream()
                .flatMap(s -> scheduleRecordRepository
                        .findBySubgroupId(s.getId()).orElseThrow().stream()).toList();
    }

    @Override
    public List<ScheduleRecord> findByGroupId(int groupId) {
        var subgroups = subgroupRepository.findByGroupId(groupId).orElseThrow();
        return subgroups.stream()
                .flatMap(s -> scheduleRecordRepository
                        .findBySubgroupId(s.getId()).orElseThrow().stream()).toList();
    }

    @Override
    public List<ScheduleRecord> findBySubgroupId(int subgroupId) {
        return scheduleRecordRepository.findBySubgroupId(subgroupId).orElseThrow();
    }
}