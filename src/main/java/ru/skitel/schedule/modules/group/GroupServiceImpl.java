package ru.skitel.schedule.modules.group;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skitel.schedule.security.role.PermissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService{
    private final GroupRepository groupRepository;
    private final PermissionRepository permissionRepository;

    @Override
    public Group insert(Group entity) {
        return groupRepository.save(entity);
    }

    @Override
    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        groupRepository.deleteById(id);
    }

    @Override
    public Group findById(int id) {
        return groupRepository.findById(id).orElseThrow();
    }

    @Override
    public Group findByNumber(String number) {
        return groupRepository.findByNumber(number).orElseThrow();
    }

    @Override
    public List<Group> findByUserId(int userId) {
        var permissions = permissionRepository.findByUserId(userId).orElseThrow();

        return permissions.stream().map(p -> groupRepository
                .findById(p.getGroup().getId()).orElseThrow()).toList();
    }
}
