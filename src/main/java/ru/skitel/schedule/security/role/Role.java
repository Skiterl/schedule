package ru.skitel.schedule.security.role;

import lombok.Getter;
import org.springframework.stereotype.Component;

public enum Role {
    USER, ADMIN;

    @Component("Role")
    @Getter
    static class SpringComponent{
        private final Role USER = Role.USER;
        private final Role ADMIN = Role.ADMIN;
    }
}
