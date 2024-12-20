package ru.skitel.schedule.api.authentication;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skitel.schedule.security.user.AuthenticationService;
import ru.skitel.schedule.security.JwtUtils;
import ru.skitel.schedule.dto.Request;
import ru.skitel.schedule.dto.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final JwtUtils jwtUtils;

    @PostMapping("/signup")
    public ResponseEntity<Response> signup(@RequestBody Request request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<Response> signin(@RequestBody Request request) throws Exception {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
