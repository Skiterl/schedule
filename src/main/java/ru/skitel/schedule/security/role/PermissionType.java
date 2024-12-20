package ru.skitel.schedule.security.role;

import lombok.Getter;
import org.springframework.stereotype.Component;

public enum PermissionType {
    READ, EDIT;

    @Component("Permission")
    @Getter
    static class SpringComponent{
        private final PermissionType READ = PermissionType.READ;
        private final PermissionType EDIT = PermissionType.EDIT;
    }
}
