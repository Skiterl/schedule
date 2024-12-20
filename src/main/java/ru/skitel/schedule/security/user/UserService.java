package ru.skitel.schedule.security.user;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    User findByEmail(String email) throws UsernameNotFoundException;
    User findById(long userId);
}
