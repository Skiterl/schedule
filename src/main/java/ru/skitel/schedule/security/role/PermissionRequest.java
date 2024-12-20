package ru.skitel.schedule.security.role;

public record PermissionRequest(long userId, int groupId, PermissionType permission) {
}
