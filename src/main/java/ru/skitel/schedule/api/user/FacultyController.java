package ru.skitel.schedule.api.user;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.skitel.schedule.modules.faculty.Faculty;
import ru.skitel.schedule.modules.faculty.FacultyMapper;
import ru.skitel.schedule.modules.faculty.FacultyService;
import ru.skitel.schedule.modules.group.GroupService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class FacultyController {
    private final FacultyService facultyService;
    private final GroupService groupService;

    @GetMapping("/faculties")
    public List<Faculty> getAll(){
        //log.info(authentication.getName() + " " + authentication.getAuthorities());
        return facultyService.getAll();
    }

    @GetMapping("/faculty/{groupId}")
    public Faculty getFacultiesByGroupId(@PathVariable int groupId){
        var group = groupService.findById(groupId);
        return facultyService.findById(group.getFaculty().getId());
    }
}
