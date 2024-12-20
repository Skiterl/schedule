package ru.skitel.schedule.api.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skitel.schedule.modules.faculty.FacultyMapper;
import ru.skitel.schedule.modules.faculty.FacultyRequest;
import ru.skitel.schedule.modules.faculty.FacultyService;
import ru.skitel.schedule.modules.group.Group;
import ru.skitel.schedule.modules.group.GroupRequest;
import ru.skitel.schedule.modules.group.GroupService;
import ru.skitel.schedule.modules.record.ScheduleRecordService;
import ru.skitel.schedule.modules.subgroup.Subgroup;
import ru.skitel.schedule.modules.subgroup.SubgroupRequest;
import ru.skitel.schedule.modules.subgroup.SubgroupService;
import ru.skitel.schedule.modules.subject.SubjectMapper;
import ru.skitel.schedule.modules.subject.SubjectRequest;
import ru.skitel.schedule.modules.subject.SubjectService;
import ru.skitel.schedule.modules.teacher.Teacher;
import ru.skitel.schedule.modules.teacher.TeacherRequest;
import ru.skitel.schedule.modules.teacher.TeacherService;
import ru.skitel.schedule.security.role.PermissionRequest;
import ru.skitel.schedule.security.role.PermissionService;
import ru.skitel.schedule.security.role.PermissionType;
import ru.skitel.schedule.security.role.Role;
import ru.skitel.schedule.security.user.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final FacultyService facultyService;
    private final SubgroupService subgroupService;
    private final GroupService groupService;
    private final TeacherService teacherService;
    private final SubjectService subjectService;
    private final UserService userService;
    private final PermissionService permissionService;

    private final FacultyMapper facultyMapper;
    private final SubjectMapper subjectMapper;

    @PostMapping("/faculty")
    public void addFaculty(@RequestBody FacultyRequest request){
        facultyService.insert(facultyMapper.convertToFaculty(request));
    }

    @PostMapping("/group")
    public void addGroup(@RequestBody GroupRequest request){
        var faculty = facultyService.findById(request.facultyId());

        var group = Group.builder()
                .number(request.number())
                .faculty(faculty)
                .direction(request.direction())
                .profile(request.profile())
                .build();

        groupService.insert(group);
    }

    @PostMapping("/teacher")
    public void addTeacher(@RequestBody TeacherRequest request){
        var faculty = facultyService.findById(request.facultyId());

        var teacher = Teacher.builder()
                .post(request.post())
                .name(request.name())
                .faculty(faculty)
                .build();

        teacherService.insert(teacher);
    }

    @PostMapping("/subject")
    public void addSubject(@RequestBody SubjectRequest request){
        subjectService.insert(subjectMapper.convertToSubject(request));
    }

    @PostMapping("/subgroup")
    public void addSubgroup(@RequestBody SubgroupRequest request){
        var group = groupService.findById(request.groupId());
        var subgroup = Subgroup.builder().group(group).number(request.number()).build();
        subgroupService.insert(subgroup);
    }

    @PostMapping("/permission")
    public void addPermission(@RequestBody PermissionRequest request){
        var user = userService.findById(request.userId());
        var subgroup = groupService.findById(request.groupId());
        permissionService.insert(request.userId(), request.groupId(), request.permission());
    }
}
