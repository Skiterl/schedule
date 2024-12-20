package ru.skitel.schedule.api.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skitel.schedule.modules.subject.Subject;
import ru.skitel.schedule.modules.subject.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping("/subjects")
    public List<Subject> getAll(Authentication authentication){
        log.info(authentication.getName() + " " + authentication.getAuthorities());
        return subjectService.getAll();
    }
}