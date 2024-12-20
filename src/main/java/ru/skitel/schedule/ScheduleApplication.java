package ru.skitel.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.skitel.schedule.dto.Request;
import ru.skitel.schedule.dto.Response;
import ru.skitel.schedule.security.JwtUtils;
import ru.skitel.schedule.security.role.Role;
import ru.skitel.schedule.security.user.AuthenticationService;
import ru.skitel.schedule.security.user.User;
import ru.skitel.schedule.security.user.UserRepository;
import ru.skitel.schedule.security.user.UserService;

@SpringBootApplication
@EnableMethodSecurity
@Slf4j
public class ScheduleApplication {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtUtils jwtUtils;

	public static void main(String[] args) {
		SpringApplication.run(ScheduleApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(){
//		return args -> {
//			var user = User.builder().email("bob").role(Role.USER)
//					.password(passwordEncoder.encode("bob")).build();
//
//			User savedUser = userRepository.save(user);
//
//			String jwtToken = jwtUtils.generateToken(user);
//
//			log.info("Generated token: {}", jwtToken);
//		};
//	}
}
