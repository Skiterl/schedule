package ru.skitel.schedule.security.role;

import java.util.List;
import java.util.Set;

public interface PermissionService {
    List<Permission> findByUserId(int userId);
    boolean includePermissionById(int userId, int groupId, PermissionType type);
    boolean includePermissionByEmail(String email, int groupId, PermissionType type);
    boolean includePermissionByIdAndSubgroupId(int userId, int subgroupId, PermissionType type);
    boolean includePermissionByEmailAndSubgroupId(String email, int subgroupId, PermissionType type);
    boolean includePermissionByEmailAndGroupId(String email, int groupId, PermissionType type);
    Permission insert(long userId, int groupId, PermissionType type);
}