package ru.skitel.schedule.modules.record;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ScheduleRecordRepository extends JpaRepository<ScheduleRecord, Integer> {
    Optional<List<ScheduleRecord>> findBySubgroupId(int subgroupId);
}
