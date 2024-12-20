package ru.skitel.schedule.security.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.skitel.schedule.security.JwtUtils;
import ru.skitel.schedule.security.role.Role;
import ru.skitel.schedule.dto.Request;
import ru.skitel.schedule.dto.Response;

@RequiredArgsConstructor
@Service
@Slf4j
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public Response register(Request request){
        var user = User.builder().email(request.email()).role(Role.USER)
                .password(passwordEncoder.encode(request.password())).build();

        User savedUser = userRepository.save(user);

        String jwtToken = jwtUtils.generateToken(user);

        log.info("Generated token: {}", jwtToken);

        return new Response(jwtToken);
    }

    public Response authenticate(Request request) throws Exception{
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.email(),
                request.password()
        ));

        var user = userRepository.findByEmail(request.email()).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));

        log.info("User found: {}", user);
        var jwtToken = jwtUtils.generateToken(user);
        log.info("Generated token: {}", jwtToken);
        return new Response(jwtToken);
    }
}
