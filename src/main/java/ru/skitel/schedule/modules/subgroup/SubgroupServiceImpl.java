package ru.skitel.schedule.modules.subgroup;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skitel.schedule.modules.group.GroupRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SubgroupServiceImpl implements SubgroupService{
    private final SubgroupRepository subgroupRepository;
    private final GroupRepository groupRepository;

    @Override
    public Subgroup insert(Subgroup entity) {
        return subgroupRepository.save(entity);
    }

    @Override
    public List<Subgroup> getAll() {
        return subgroupRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        subgroupRepository.deleteById(id);
    }

    @Override
    public List<Subgroup> findByGroupId(int groupId) {
        return subgroupRepository.findByGroupId(groupId).orElseThrow();
    }

    @Override
    public List<Subgroup> findByGroupNumber(String number) {
        var group = groupRepository.findByNumber(number).orElseThrow();

        return subgroupRepository.findByGroupId(group.getId()).orElseThrow();
    }

    @Override
    public Subgroup findById(int id) {
        return subgroupRepository.findById(id).orElseThrow();
    }
}
