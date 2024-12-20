package ru.skitel.schedule.api.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skitel.schedule.modules.group.GroupService;
import ru.skitel.schedule.modules.teacher.Teacher;
import ru.skitel.schedule.modules.teacher.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class TeacherController {
    private final TeacherService teacherService;
    private final GroupService groupService;

    @GetMapping("/teachers")
    public List<Teacher> getAll(Authentication authentication){
        log.info(authentication.getName() + " " + authentication.getAuthorities());

        return teacherService.getAll();
    }

    @GetMapping("/teachers/{groupId}")
    public List<Teacher> getTeachersByGroupId(@PathVariable int groupId){
        var group = groupService.findById(groupId);
        return teacherService.findByFacultyId(group.getFaculty().getId());
    }
}