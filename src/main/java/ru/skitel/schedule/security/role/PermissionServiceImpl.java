package ru.skitel.schedule.security.role;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skitel.schedule.modules.group.GroupRepository;
import ru.skitel.schedule.modules.subgroup.SubgroupRepository;
import ru.skitel.schedule.modules.subgroup.SubgroupService;
import ru.skitel.schedule.security.user.UserRepository;

import java.util.List;
import java.util.Set;

@Service("PermissionService")
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService
{
    private final PermissionRepository permissionRepository;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final SubgroupService subgroupService;

    @Override
    public List<Permission> findByUserId(int userId) {
        return permissionRepository.findByUserId(userId).orElseThrow();
    }

    @Override
    public boolean includePermissionById(int userId, int groupId, PermissionType type) {
        var permissions = permissionRepository.findByUserId(userId).orElseThrow();

        if(permissions.isEmpty()){
            return false;
        }

        return permissions.stream().allMatch(p ->
            p.getGroup().getId() == groupId && p.getType().name().equals(type.name())
        );
    }

    @Override
    public boolean includePermissionByIdAndSubgroupId(int userId, int subgroupId, PermissionType type) {
        var permissions = permissionRepository.findByUserId(userId).orElseThrow();
        var subgroup = subgroupService.findById(subgroupId);

        if(permissions.isEmpty()){
            return false;
        }

        return permissions.stream().allMatch(p ->
                p.getGroup().getId() == subgroup.getGroup().getId() && p.getType().name().equals(type.name())
        );
    }

    @Override
    public boolean includePermissionByEmailAndSubgroupId(String email, int subgroupId, PermissionType type) {
        var user = userRepository.findByEmail(email).orElseThrow();
        var permissions = permissionRepository.findByUserId(user.getId()).orElseThrow();
        var subgroup = subgroupService.findById(subgroupId);

        if(permissions.isEmpty()){
            return false;
        }

        return permissions.stream().allMatch(p ->
                p.getGroup().getId() == subgroup.getGroup().getId() && p.getType().name().equals(type.name())
        );
    }

    @Override
    public boolean includePermissionByEmailAndGroupId(String email, int groupId, PermissionType type) {
        var user = userRepository.findByEmail(email).orElseThrow();
        var permissions = permissionRepository.findByUserId(user.getId()).orElseThrow();

        if(permissions.isEmpty()){
            return false;
        }

        return permissions.stream().allMatch(p -> p.getGroup().getId() == groupId && p.getType().name().equals(type.name()));
    }

    @Override
    public boolean includePermissionByEmail(String email, int groupId, PermissionType type) {
        var user = userRepository.findByEmail(email).orElseThrow();
        var permissions = permissionRepository.findByUserId(user.getId()).orElseThrow();

        if(permissions.isEmpty()){
            return false;
        }

        return permissions.stream().allMatch(p ->
                p.getGroup().getId() == groupId && p.getType().name().equals(type.name())
        );
    }

    @Override
    public Permission insert(long userId, int groupId, PermissionType type) {
        var user = userRepository.findById(userId).orElseThrow();
        var group = groupRepository.findById(groupId).orElseThrow();

        var permission = Permission.builder().user(user).group(group).type(type).build();
        return permissionRepository.save(permission);
    }
}
