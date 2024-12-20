package ru.skitel.schedule.security.role;

import lombok.Getter;

@Getter
public class Constants {
    public static final String ValidAdminRole = "@Role.ADMIN.name().equals(authentication.getAuthorities().stream().toList().getFirst().getAuthority())";
}
