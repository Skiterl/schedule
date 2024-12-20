package ru.skitel.schedule.modules.subgroup;

import org.springframework.stereotype.Service;
import ru.skitel.schedule.modules.base.BaseService;

import java.util.List;
import java.util.Set;

public interface SubgroupService extends BaseService<Subgroup> {
    List<Subgroup> findByGroupId(int groupId);
    List<Subgroup> findByGroupNumber(String number);
    Subgroup findById(int id);
}
